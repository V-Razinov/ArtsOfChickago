@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package com.example.artsdomain.mapper

import com.example.artsdata.model.ArtPojo
import com.example.artsdomain.ArtImageLinkBuilder
import com.example.artsdomain.model.ArtListItem
import com.example.common.Mapper
import javax.inject.Inject

class ArtToArtListItemMapper @Inject constructor() : Mapper<ArtPojo, ArtListItem> {

    override operator fun invoke(artPojo: ArtPojo): ArtListItem =
        ArtListItem(
            id = artPojo.id,
            name = artPojo.title,
            authors = artPojo.artist_titles.joinToString(separator = ", "),
            imageUrl = when (val id = artPojo.image_id ?: artPojo.alt_image_ids.firstOrNull()) {
                null -> null
                else -> ArtImageLinkBuilder()
                    .imageId(id)
                    .width(100)
                    .build()
            }
        )
}