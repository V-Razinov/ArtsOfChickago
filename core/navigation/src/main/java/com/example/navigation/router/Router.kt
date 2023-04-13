package com.example.navigation.router

import com.example.navigation.Route
import com.example.navigation.RouterCommand
import kotlinx.coroutines.flow.Flow

interface Router {
    val commandsFlow: Flow<RouterCommand>

    fun navigate(route: Route)
    fun back()
    fun backTo(route: Route)
    fun replace(route: Route)
}

