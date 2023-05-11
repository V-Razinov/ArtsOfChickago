package com.example.common.di

import com.example.common.json_converter.GsonJsonConverter
import com.example.common.json_converter.JsonConverter
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JsonConvertersModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideJsonConverter(gson: Gson): JsonConverter = GsonJsonConverter(gson)

}