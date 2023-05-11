package com.example.type_converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.common.json_converter.JsonConverter

@ProvidedTypeConverter
class ListStringTypeConverter(
    private val jsonConverter: JsonConverter
) {

    @TypeConverter
    fun listToJson(list: List<String>): String =
        jsonConverter.toJson(list).orEmpty()

    @TypeConverter
    fun jsonToList(json: String): List<String> =
        jsonConverter.fromJson<List<String>>(json).orEmpty()

}