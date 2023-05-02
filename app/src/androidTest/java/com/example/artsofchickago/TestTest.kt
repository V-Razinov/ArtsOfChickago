package com.example.artsofchickago

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class TestTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("myInt")
    @JvmField
    var myInt: Int = -1

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun test_test() {
        assert(true)
    }

}