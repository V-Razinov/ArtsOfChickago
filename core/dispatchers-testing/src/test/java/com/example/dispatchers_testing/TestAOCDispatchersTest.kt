package com.example.dispatchers_testing

import com.example.dispatchers.AOCDispatchers
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class TestAOCDispatchersTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var dispatchers: AOCDispatchers

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `main dispatcher is TestDispatcher, correct`() {
        assert(dispatchers.Main is TestDispatcher)
    }

}