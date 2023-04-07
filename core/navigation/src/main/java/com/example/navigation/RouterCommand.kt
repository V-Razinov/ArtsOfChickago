package com.example.navigation

sealed interface RouterCommand {
    data class Navigate(val screen: Screen) : RouterCommand
    object Back : RouterCommand
    data class BackTo(val screen: Screen) : RouterCommand
    data class Replace(val screen: Screen) : RouterCommand
}