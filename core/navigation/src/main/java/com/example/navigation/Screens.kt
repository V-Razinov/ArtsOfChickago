package com.example.navigation

import androidx.navigation.NamedNavArgument

interface Screen {
    val route: String
    val routeFormatted: String get() = route
}

object ArtsListScreen : Screen {
    override val route: String = "arts"
}

data class ArtDetailsScreen(
    val userId: Int,
) : Screen {
    override val route: String = Companion.route
    override val routeFormatted: String = route.replace("{userId}", userId.toString())

    companion object {
        const val route = "profile?userId={userId}"

        const val NO_USER_ID = -1
        val args: List<NamedNavArgument> get() = listOf(intNavArgument("userId", NO_USER_ID))
    }
}