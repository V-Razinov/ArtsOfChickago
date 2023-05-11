package com.example.common.json_converter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

internal class GsonJsonConverter(
    private val gson: Gson,
) : JsonConverter {

    override fun <T> toJson(obj: T?): String? {
        obj ?: return null
        return try {
            gson.toJson(obj, object : TypeToken<T>() {}.type)
        } catch (e: Exception) {
            null
        }
    }

    override fun <T> fromJson(json: String?): T? {
        json ?: return null
        return try {
            gson.fromJson<T>(json, object : TypeToken<T>() {}.type)
        } catch (e: Exception) {
            null
        }
    }
}