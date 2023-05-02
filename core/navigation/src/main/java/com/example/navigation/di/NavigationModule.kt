package com.example.navigation.di

import com.example.navigation.router.ChannelRouter
import com.example.navigation.router.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {

    @Provides
    @Singleton
    fun provideRouter(): Router = ChannelRouter()

}