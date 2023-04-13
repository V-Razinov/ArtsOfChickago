package com.example.artsofchickago.ui.componets

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.arts.arts
import com.example.arts.artsListRoute
import com.example.navigation.router.Router
import com.example.splash
import com.example.splashRoute

@Composable
fun AOCNavHost(navController: NavHostController, router: Router) {
    NavHost(
        navController = navController,
        startDestination = splashRoute.value
    ) {
        splash(onFinish = { router.replace(artsListRoute) })
        arts()
    }
}