package com.example.arts.ui.artslist

import com.example.artsdomain.model.ArtListItem

internal data class ArtsListState(
    val arts: List<ArtListItem> = emptyList(),
    val isLoading: Boolean = false,
)