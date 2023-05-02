package com.example.dispatchers_testing

import com.example.dispatchers.AOCDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher

@ExperimentalCoroutinesApi
class TestAOCDispatchers : AOCDispatchers(
    Main = StandardTestDispatcher()
)