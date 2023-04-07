package com.example.artsofchickago.ui.arts

import com.example.artsofchicago.di.Art

data class ArtsState(
    val arts: List<Art> = emptyList(),
    val isLoading: Boolean = false,
)