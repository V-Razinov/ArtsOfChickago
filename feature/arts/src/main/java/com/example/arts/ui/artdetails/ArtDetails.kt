package com.example.arts.ui.artdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.arts.ArtDetailsArgs

@Composable
fun ArtDetails() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Art Details")
    }
}

internal class ArtDetailsViewModel constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val args = ArtDetailsArgs(savedStateHandle)

}