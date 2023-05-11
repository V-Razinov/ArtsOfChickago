package com.example.utils.extensions

fun String.replace(vararg pairs: Pair<String, String>): String {
    var str = this
    pairs.forEach { pair ->
        str = str.replace(pair.first, pair.second)
    }
    return str
}