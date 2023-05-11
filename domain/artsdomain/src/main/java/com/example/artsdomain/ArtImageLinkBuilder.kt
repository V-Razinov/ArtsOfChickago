package com.example.artsdomain

import com.example.utils.extensions.replace

// "https://www.artic.edu/iiif/2/${id}/full/100,/0/default.jpg"

private const val idPath = "{id}"
private const val widthPath = "{width}"
private const val heightPath = "{height}"

internal class ArtImageLinkBuilder {

    private var baseUrl = "https://www.artic.edu/iiif/2/$idPath/full/$widthPath,$heightPath/0/default.jpg"

    private var id = ""
    private var width = 100
    private var height = 0

    fun imageId(id: String): ArtImageLinkBuilder = apply { this.id = id }

    fun width(width: Int): ArtImageLinkBuilder = apply { this.width = width }

    fun height(height: Int): ArtImageLinkBuilder = apply { this.height = height }

    fun size(width: Int, height: Int): ArtImageLinkBuilder = width(width).height(height)

    fun size(size: Int): ArtImageLinkBuilder = size(width, height)

    fun build(): String = baseUrl
        .replace(
            idPath to id,
            widthPath to width.coerceAtLeast(100).toString(),
            heightPath to height.takeIf { it > 0 }?.toString().orEmpty()
        )

}