package com.example.arts.ui.artdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.arts.ArtDetailsArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
internal class ArtDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val args = ArtDetailsArgs(savedStateHandle)

    private val _state = MutableStateFlow(ArtDetailsState(id = args.artId))
    val state = _state.asStateFlow()

}