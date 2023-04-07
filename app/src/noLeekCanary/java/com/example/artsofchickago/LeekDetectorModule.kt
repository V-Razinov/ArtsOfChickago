package com.example.artsofchickago

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LeekDetectorModule {

    @Provides
    @Singleton
    fun provideLeekDetector() : LeekDetector = EmptyLeekDetector()

}