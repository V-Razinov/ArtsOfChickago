package com.example.arts

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.arts.ui.artdetails.ArtDetails
import com.example.arts.ui.artslist.ArtsListScreen

const val artsListRoute = "arts"
const val artDetailsRoute = "art_details?artId={artId}"

internal data class ArtDetailsArgs(
    val artId: String
) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        artId = savedStateHandle.get<String>("artId").orEmpty()
    )
}

fun NavGraphBuilder.arts() {
    composable(artsListRoute) { ArtsListScreen() }
    composable(artDetailsRoute) { ArtDetails() }
}