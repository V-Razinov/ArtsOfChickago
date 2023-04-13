package com.example.navigation

sealed interface RouterCommand {
    data class Navigate(val route: Route) : RouterCommand
    object Back : RouterCommand
    data class BackTo(val route: Route) : RouterCommand
    data class Replace(val route: Route) : RouterCommand
}