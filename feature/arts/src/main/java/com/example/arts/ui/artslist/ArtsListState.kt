package com.example.arts.ui.artslist

import team.mediasoft.artsdomain.model.ArtListItem

internal data class ArtsListState(
    val arts: List<ArtListItem> = emptyList(),
    val isLoading: Boolean = false,
)