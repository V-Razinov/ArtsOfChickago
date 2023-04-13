@file:SuppressLint("ComposableNaming")

package com.example.utils.extensions

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

@Composable
fun <T> Flow<T>.asLaunchedEffect(
    key: Any?,
    collector: FlowCollector<T>
) {
    LaunchedEffect(key1 = key) {
        collect(collector)
    }
}