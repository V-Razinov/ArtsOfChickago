package com.example.common.json_converter

interface JsonConverter {

    fun <T> toJson(obj: T?): String?

    fun <T> fromJson(json: String?): T?

}