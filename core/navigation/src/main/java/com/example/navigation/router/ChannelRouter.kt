package com.example.navigation.router

import com.example.navigation.Route
import com.example.navigation.RouterCommand
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

internal class ChannelRouter(
    commandsBufferSize: Int = DEFAULT_COMMANDS_BUFFER_SIZE,
) : Router {

    private val commandsChannel = Channel<RouterCommand>(capacity = commandsBufferSize)
    override val commandsFlow: Flow<RouterCommand> get() = commandsChannel.receiveAsFlow()

    override fun navigate(route: Route) {
        commandsChannel.trySend(RouterCommand.Navigate(route))
    }

    override fun back() {
        commandsChannel.trySend(RouterCommand.Back)
    }

    override fun backTo(route: Route) {
        commandsChannel.trySend(RouterCommand.BackTo(route))
    }

    override fun replace(route: Route) {
        commandsChannel.trySend(RouterCommand.Replace(route))
    }

    companion object {
        private const val DEFAULT_COMMANDS_BUFFER_SIZE = 64
    }

}