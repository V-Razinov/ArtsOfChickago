package com.example.navigation.router

import com.example.navigation.RouterCommand
import com.example.navigation.Screen
import kotlinx.coroutines.flow.Flow

interface Router {
    val commandsFlow: Flow<RouterCommand>

    fun navigate(screen: Screen)
    fun back()
    fun backTo(screen: Screen)
    fun replace(screen: Screen)
}

