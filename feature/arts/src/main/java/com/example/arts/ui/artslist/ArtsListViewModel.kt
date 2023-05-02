package com.example.arts.ui.artslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arts.artDetailsRoute
import com.example.navigation.router.Router
import com.example.navigation.withParam
import com.example.utils.Result
import com.example.utils.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import com.example.artsdomain.model.ArtListItem
import com.example.artsdomain.usecase.GetArtsUseCase
import com.example.dispatchers.AOCDispatchers
import javax.inject.Inject

@HiltViewModel
internal class ArtsListViewModel @Inject constructor(
    getArtsUseCase: GetArtsUseCase,
    private val router: Router,
    private val dispatchers: AOCDispatchers,
) : ViewModel() {

    val state: StateFlow<ArtsListState> =
        getArtsUseCase(page = 1, pageSize = 20)
            .asResult()
            .map { result ->
                when (result) {
                    is Result.Loading -> ArtsListState(
                        isLoading = true,
                        arts = emptyList()
                    )
                    is Result.Success -> ArtsListState(
                        isLoading = false,
                        arts = result.data.arts
                    )
                    is Result.Error -> ArtsListState(isLoading = false)
                }
            }
            .stateIn(viewModelScope, started = SharingStarted.Lazily, ArtsListState())

    fun onArtClick(art: ArtListItem) {
        val route = artDetailsRoute
            .withParam("artId", art.id.toString())
        router.navigate(route)
    }

}