@file:SuppressLint("ComposableNaming")
@file:Suppress("NOTHING_TO_INLINE")

package com.example.utils.extensions

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

@Composable
inline fun <T> Flow<T>.asLaunchedEffect(
    key: Any?,
    collector: FlowCollector<T>
) {
    LaunchedEffect(key1 = key) {
        collect(collector)
    }
}