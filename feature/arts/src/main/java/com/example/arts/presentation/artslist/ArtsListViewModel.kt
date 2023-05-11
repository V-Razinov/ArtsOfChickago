package com.example.arts.presentation.artslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.arts.artDetailsRoute
import com.example.artsdomain.model.ArtListItem
import com.example.artsdomain.usecase.GetArtsPagingUseCase
import com.example.dispatchers.AOCDispatchers
import com.example.navigation.router.Router
import com.example.navigation.withParam
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class ArtsListViewModel @Inject constructor(
    getArtsPagingUseCase: GetArtsPagingUseCase,
    private val router: Router,
    private val dispatchers: AOCDispatchers,
) : ViewModel() {

    private val artsPagingFlow = getArtsPagingUseCase()
        .cachedIn(viewModelScope)

    val state: StateFlow<ArtsListState> =
        flow { emit(ArtsListState(arts = artsPagingFlow)) }
            .stateIn(viewModelScope, started = SharingStarted.Lazily, ArtsListState())

    fun onArtClick(art: ArtListItem) {
        val route = artDetailsRoute
            .withParam("artId", art.id.toString())
        router.navigate(route)
    }

}