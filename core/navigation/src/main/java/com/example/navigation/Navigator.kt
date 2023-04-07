package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.utils.extensions.asLaunchedEffect
import com.example.navigation.router.Router

@Composable
fun AppNavigator(navController: NavHostController, router: Router) {
    router.commandsFlow.asLaunchedEffect(key = navController) { routerCommand: RouterCommand ->
        when (routerCommand) {
            is RouterCommand.Navigate -> navigate(navController, routerCommand)
            RouterCommand.Back -> back(navController)
            is RouterCommand.BackTo -> backTo(navController, routerCommand)
            is RouterCommand.Replace -> replace(navController, routerCommand)
        }
    }
}

private fun navigate(
    navController: NavHostController,
    routerCommand: RouterCommand.Navigate
) = navController.navigate(routerCommand.screen.routeFormatted)

private fun back(
    navController: NavHostController
) = navController.popBackStack()

private fun replace(
    navController: NavHostController,
    routerCommand: RouterCommand.Replace
) = with(navController) {
    popBackStack()
    navController.navigate(routerCommand.screen.routeFormatted)
}

private fun backTo(
    navController: NavHostController,
    routerCommand: RouterCommand.BackTo
) = navController.popBackStack(
    routerCommand.screen.routeFormatted,
    inclusive = false,
    saveState = false
)