package com.example.navigation.router

import com.example.navigation.RouterCommand
import com.example.navigation.Screen
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

internal class ChannelRouter (
    commandsBufferSize: Int = DEFAULT_COMMANDS_BUFFER_SIZE
) : Router {

    private val commandsChannel = Channel<RouterCommand>(capacity = commandsBufferSize)
    override val commandsFlow: Flow<RouterCommand> get() = commandsChannel.receiveAsFlow()

    override fun navigate(screen: Screen) {
        commandsChannel.trySend(RouterCommand.Navigate(screen))
    }

    override fun back() {
        commandsChannel.trySend(RouterCommand.Back)
    }

    override fun backTo(screen: Screen) {
        commandsChannel.trySend(RouterCommand.BackTo(screen))
    }

    override fun replace(screen: Screen) {
        commandsChannel.trySend(RouterCommand.Replace(screen))
    }

    companion object {
        private const val DEFAULT_COMMANDS_BUFFER_SIZE = 64
    }

}