package com.example.artsofchickago.data

data class ArtsDao(
    val data: List<Data>
) {
    data class Data(
        val id: Int,
        val title: String,
        val artist_titles: List<String>,
        val image_id: String
    )
}