package com.example.artsdomain

// "https://www.artic.edu/iiif/2/${id}/full/100,/0/default.jpg"

internal class ArtImageLinkBuilder {

    private var baseUrl = "https://www.artic.edu/iiif/2/{id}/full/{width},{height}/0/default.jpg"

    private var id = ""
    private var width = 100
    private var height = 0

    fun imageId(id: String) = apply { this.id = id }

    fun width(width: Int) = apply { this.width = width }

    fun height(height: Int) = apply { this.height = height }

    fun size(width: Int, height: Int) = width(width).height(height)

    fun build(): String = baseUrl
        .replace("{id}", id)
        .replace("{width}", minOf(100, width).toString())
        .replace("{height}", height.takeIf { it > 0 }?.toString().orEmpty())

}