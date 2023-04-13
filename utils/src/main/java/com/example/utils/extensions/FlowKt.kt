package com.example.utils.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun <T> Flow<T>.collectIn(
    scope: CoroutineScope,
    collector: FlowCollector<T>,
) = scope.launch { collect(collector) }

fun <T> Flow<T>.collectLatestIn(
    scope: CoroutineScope,
    collector: (value: T) -> Unit,
) = scope.launch { collectLatest(collector) }