package com.example.artsofchickago.ui.arts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artsofchicago.di.Art
import com.example.artsofchickago.data.ArtsOfChicagoRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtsViewModel : ViewModel() {

    private val _artsState = MutableStateFlow(ArtsState())
    val artsState = _artsState.asStateFlow()

    init {
        viewModelScope.launch {
            _artsState.update { it.copy(isLoading = true) }
            val artsDao = withContext(Dispatchers.IO) {
                ArtsOfChicagoRetrofit.artOfChicagoApi.getArts()
            }
            val arts = artsDao.data.map { artDao ->
                Art(
                    id = artDao.id,
                    image = "https://www.artic.edu/iiif/2/${artDao.image_id}/full/843,/0/default.jpg",
                    name = artDao.title,
                    authors = artDao.artist_titles.joinToString(
                        separator = ","
                    )
                )
            }
            _artsState.update { oldState ->
                oldState.copy(arts = arts, isLoading = false)
            }
        }
    }

    fun onArtClick(art: Art) {

    }

}