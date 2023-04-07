package com.example.navigation.di

import com.example.navigation.router.ChannelRouter
import com.example.navigation.router.Router
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NavigationModule {

    @Provides
    @Singleton
    fun provideRouter(): Router = ChannelRouter()

}