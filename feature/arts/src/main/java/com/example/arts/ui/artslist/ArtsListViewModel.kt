package com.example.arts.ui.artslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arts.artDetailsRoute
import com.example.arts.ui.artdetails.ArtDetailsScreen
import com.example.navigation.getValue
import com.example.navigation.router.Router
import com.example.navigation.withParam
import com.example.utils.Result
import com.example.utils.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import team.mediasoft.artsdomain.model.ArtListItem
import team.mediasoft.artsdomain.usecase.GetArtsUseCase
import javax.inject.Inject

@HiltViewModel
internal class ArtsListViewModel @Inject constructor(
    getArtsUseCase: GetArtsUseCase,
    private val router: Router,
) : ViewModel() {

    val state: StateFlow<ArtsListState> =
        getArtsUseCase(page = 1, pageSize = 20)
            .asResult()
            .map { result ->
                when (result) {
                    is Result.Loading -> ArtsListState(
                        isLoading = true,
                        arts = result.data?.arts.orEmpty()
                    )
                    is Result.Success -> ArtsListState(
                        isLoading = false,
                        arts = result.data.arts
                    )
                    is Result.Error -> ArtsListState(isLoading = false)
                }
            }
            .flowOn(Dispatchers.IO)
            .stateIn(viewModelScope, started = SharingStarted.Lazily, ArtsListState())

    fun onArtClick(art: ArtListItem) {
        val route = artDetailsRoute
            .withParam("artId", art.id.toString())
        router.navigate(route)
    }

}