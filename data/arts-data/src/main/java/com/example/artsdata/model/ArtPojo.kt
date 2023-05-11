package com.example.artsdata.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ProvidedTypeConverter
import com.example.artsdata.model.ArtPojo.Companion.tableName

@Entity(tableName = tableName)
data class ArtPojo(
    @PrimaryKey val id: Int,
    val title: String,
    val artist_titles: List<String>,
    val image_id: String?,
    val alt_image_ids: List<String>,
) {
    companion object {
        const val tableName = "art_list_items"
    }
}