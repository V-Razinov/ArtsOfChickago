@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package com.example.artsdomain.mapper

import com.example.artsdata.model.ArtsResponse
import com.example.artsdomain.model.ArtsResult
import com.example.common.Mapper
import javax.inject.Inject

internal class ArtResponseToArtsResultMapper @Inject constructor(
    private val artToArtListItemMapper: ArtToArtListItemMapper,
    private val paginationMapper: PaginationMapper,
) : Mapper<ArtsResponse, ArtsResult> {

    override operator fun invoke(artsResponse: ArtsResponse): ArtsResult =
        ArtsResult(
            pagingInfo = paginationMapper(artsResponse.pagination),
            arts = artsResponse.data.map(artToArtListItemMapper::invoke)
        )

}