package com.example.artsofchicago.di

import com.example.network.ArtOfChicagoRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ArtsOfChicagoDataModule {

    @Provides
    @Singleton
    @ArtOfChicagoRetrofit
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
//        .baseUrl(BuildConfig.ARTS_OF_CHICAGO_BASE_URL)
        .build()

}