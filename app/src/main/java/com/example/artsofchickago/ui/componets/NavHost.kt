package com.example.artsofchickago.ui.componets

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.arts.arts
import com.example.navigation.ArtsListScreen
import com.example.navigation.router.Router
import com.example.splash
import com.example.splash_route

@Composable
fun AppNavHost(navController: NavHostController, router: Router) {
    NavHost(
        navController = navController,
        startDestination = splash_route
    ) {
        splash(onFinish = { router.replace(ArtsListScreen) })
        arts()
    }
}