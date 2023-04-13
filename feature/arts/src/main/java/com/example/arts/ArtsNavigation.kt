package com.example.arts

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.arts.ui.artdetails.ArtDetailsScreen
import com.example.arts.ui.artslist.ArtsListScreen
import com.example.navigation.Route

val artsListRoute = Route("arts")
val artDetailsRoute = Route("art_details?artId={artId}")

fun NavGraphBuilder.arts() {
    composable(artsListRoute.value) { ArtsListScreen() }
    composable(
        artDetailsRoute.value,
        arguments = listOf(navArgument("artId") { type = NavType.IntType; defaultValue = -1 })
    ) { ArtDetailsScreen() }
}

internal data class ArtDetailsArgs(
    val artId: Int
) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        artId = checkNotNull(savedStateHandle["artId"])
    )
}