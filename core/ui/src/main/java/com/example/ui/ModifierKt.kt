package com.example.ui

import androidx.compose.ui.Modifier

inline fun Modifier.addIf(
    condition: Boolean,
    block: Modifier.() -> Modifier,
) = when (condition) {
    true -> this.block()
    else -> this
}