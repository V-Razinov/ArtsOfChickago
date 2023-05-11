package com.example.dispatchers_testing

import com.example.dispatchers.AOCDispatchers
import com.example.dispatchers.di.AOCDispatchersModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AOCDispatchersModule::class]
)
object TestAOCDispatchersModule {

    @Provides
    @Singleton
    @OptIn(ExperimentalCoroutinesApi::class)
    fun provideAOCDispatchers(): AOCDispatchers = TestAOCDispatchers()

}