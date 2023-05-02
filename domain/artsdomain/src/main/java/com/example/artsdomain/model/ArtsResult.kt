package com.example.artsdomain.model

data class ArtsResult(
    val pagingInfo: PagingInfo,
    val arts: List<ArtListItem>,
)