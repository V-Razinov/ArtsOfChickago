package com.example.artsdata.model

import com.example.artsdata.model.common.Pagination

data class ArtsResponse(
    val pagination: Pagination,
    val data: List<ArtPojo>,
)