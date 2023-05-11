package com.example.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

abstract class AOCDispatchers(
    open val Main: CoroutineDispatcher = Dispatchers.Main,
    open val IO: CoroutineDispatcher = Dispatchers.IO,
    open val Default: CoroutineDispatcher = Dispatchers.Default,
    open val Unconfined: CoroutineDispatcher = Dispatchers.Unconfined,
)