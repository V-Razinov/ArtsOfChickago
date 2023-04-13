package com.example.artsdata.model

import com.example.artsdata.model.common.Pagination

data class ArtsResponse(
    val pagination: Pagination,
    val data: List<Art>
) {

    data class Art(
        val id: Int,
        val title: String,
        val artist_titles: List<String>,
        val image_id: String?,
        val alt_image_ids: List<String>,
    )
}