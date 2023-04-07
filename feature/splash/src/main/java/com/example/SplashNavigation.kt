package com.example

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.splash.Splash

const val splash_route = "splash"

fun NavGraphBuilder.splash(onFinish: () -> Unit) {
    composable(splash_route) {
        Splash(onFinish)
    }
}