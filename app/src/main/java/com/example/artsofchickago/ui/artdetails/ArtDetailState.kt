package com.example.artsofchickago.ui.artdetails

data class ArtDetailState(
    val id: Int = -1,
    val name: String = "",
    val image: String = "",
    val authors: String = "",
    val isLoading: Boolean,
)