package com.example.di

import com.example.common.json_converter.JsonConverter
import com.example.type_converter.ListStringTypeConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomTypeConvertersModule {

    @Provides
    @TypeConverterQualifier.ListStringTypeConverter
    fun provideListStringTypeConverter(
        jsonConverter: JsonConverter,
    ): Any = ListStringTypeConverter(jsonConverter)

}