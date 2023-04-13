package com.example

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Route
import com.example.splash.Splash

val splashRoute = Route("splash")

fun NavGraphBuilder.splash(onFinish: () -> Unit) {
    composable(splashRoute.value) { Splash(onFinish) }
}