@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package com.example.artsdomain.mapper

import com.example.artsdata.model.common.Pagination
import com.example.artsdomain.model.PagingInfo
import com.example.common.Mapper
import javax.inject.Inject

internal class PaginationMapper @Inject constructor() : Mapper<Pagination, PagingInfo> {

    override operator fun invoke(pagination: Pagination): PagingInfo =
        PagingInfo(
            totalPages = pagination.total_pages,
            currentPage = pagination.current_page,
            totalItems = pagination.total
        )

}