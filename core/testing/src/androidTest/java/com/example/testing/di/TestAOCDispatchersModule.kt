package com.example.testing.di

import com.example.dispatchers.AOCDispatchers
import com.example.dispatchers.di.AOCDispatchersModule
import com.example.testing.TestAOCDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AOCDispatchersModule::class]
)
@ExperimentalCoroutinesApi
object TestAOCDispatchersModule {
    @Provides
    @Singleton
    fun provideAOCDispatchers(): AOCDispatchers = TestAOCDispatchers()
}