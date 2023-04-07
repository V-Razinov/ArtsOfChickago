package com.example.artsofchickago.ui.artdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.artsofchickago.data.ArtsOfChicagoRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class ArtDetailsViewModel(private val artId: Int) : ViewModel() {
    companion object {
        @Suppress("FunctionName")
        fun Factory(artId: Int): ViewModelProvider.Factory =
            viewModelFactory { initializer { ArtDetailsViewModel(artId) } }
    }

    val state = flow { emit(ArtsOfChicagoRetrofit.artOfChicagoApi.getArt(artId)) }
        .map { it.data }
        .map { art ->
            ArtDetailState(
                id = art.id,
                name = art.title,
                image = "https://www.artic.edu/iiif/2/${art.image_id}/full/843,/0/default.jpg",
                authors = art.artist_titles.joinToString(),
                isLoading = false
            )
        }
        .flowOn(Dispatchers.IO)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = ArtDetailState(isLoading = true)
        )
}