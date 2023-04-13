package com.example.artsdata.di

import com.example.artsdata.repository.ArtsOfChicagoApi
import com.example.artsdata.repository.ArtsOfChicagoRepository
import com.example.artsdata.repository.ArtsOfChicagoRepositoryRemoteImpl
import com.example.network.BuildConfig
import com.example.network.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ArtsDataModule {

    @Provides
    @Singleton
    fun provideArtsApi(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): ArtsOfChicagoApi =
        Retrofit.Builder()
            .baseUrl(BuildConfig.ARTS_OF_CHICAGO_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
            .create(ArtsOfChicagoApi::class.java)

    @Provides
    @Singleton
    fun provideArtOfChicagoRepository(
        artApi: ArtsOfChicagoApi,
    ): ArtsOfChicagoRepository =
        ArtsOfChicagoRepositoryRemoteImpl(
            artsOfChicagoService = artApi
        )

}