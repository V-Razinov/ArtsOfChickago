@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package com.example.artsdomain.mapper

import com.example.artsdata.model.ArtsResponse
import com.example.artsdomain.ArtImageLinkBuilder
import com.example.artsdomain.model.ArtListItem
import com.example.common.Mapper
import javax.inject.Inject

internal class ArtToArtListItemMapper @Inject constructor() : Mapper<ArtsResponse.Art, ArtListItem> {

    override operator fun invoke(art: ArtsResponse.Art): ArtListItem =
        ArtListItem(
            id = art.id,
            name = art.title,
            authors = art.artist_titles.joinToString(separator = ", "),
            imageUrl = when (val id = art.image_id ?: art.alt_image_ids.firstOrNull()) {
                null -> null
                else -> ArtImageLinkBuilder()
                    .imageId(id)
                    .width(100)
                    .build()
            }
        )
}