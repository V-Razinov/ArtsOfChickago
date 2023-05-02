package com.example.artsdata.model.common

data class Pagination(
    val total: Int,
    val limit: Int,
    val offset: Int,
    val total_pages: Int,
    val current_page: Int,
)