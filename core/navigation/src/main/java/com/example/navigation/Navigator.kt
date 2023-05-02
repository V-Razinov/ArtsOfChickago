package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.navigation.router.Router
import com.example.utils.extensions.asLaunchedEffect

@Composable
fun AppNavigator(navController: NavHostController, router: Router) {
    router.commandsFlow.asLaunchedEffect(key = navController) { routerCommand: RouterCommand ->
        when (routerCommand) {
            is RouterCommand.Navigate ->
                navigate(navController, routerCommand)
            RouterCommand.Back ->
                back(navController)
            is RouterCommand.BackTo ->
                backTo(navController, routerCommand)
            is RouterCommand.Replace ->
                replace(navController, routerCommand)
        }
    }
}

private fun navigate(
    navController: NavHostController,
    routerCommand: RouterCommand.Navigate,
) = navController.navigate(routerCommand.route.value)

private fun back(
    navController: NavHostController,
) = navController.popBackStack()

private fun replace(
    navController: NavHostController,
    routerCommand: RouterCommand.Replace,
) = navController.navigate(routerCommand.route.value) {
    val currentRoute = navController.currentBackStackEntry
        ?.destination
        ?.route
    if (currentRoute != null) {
        popUpTo(currentRoute) { inclusive = true }
    }
}

private fun backTo(
    navController: NavHostController,
    routerCommand: RouterCommand.BackTo,
) = navController.popBackStack(
    routerCommand.route.value,
    inclusive = false,
    saveState = false
)