package com.example.dispatchers.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.dispatchers.AOCDispatchers
import com.example.dispatchers.AOCDispatchersImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AOCDispatchersModule {

    @Provides
    @Singleton
    fun provideAOCDispatchers(): AOCDispatchers = AOCDispatchersImpl()

}