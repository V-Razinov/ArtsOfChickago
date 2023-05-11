package com.example.artsdata.di

import android.content.Context
import androidx.room.Room
import com.example.artsdata.api.ArtsOfChicagoApi
import com.example.artsdata.db.ArtsDataBase
import com.example.artsdata.repository.ArtsOfChicagoRepository
import com.example.artsdata.repository.ArtsOfChicagoRepositoryImpl
import com.example.di.TypeConverterQualifier
import com.example.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArtsDataModule {

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
        ArtsOfChicagoRepositoryImpl(
            artsOfChicagoApi = artApi
        )

    @Provides
    @Singleton
    fun provideArtsDataBase(
        @ApplicationContext
        context: Context,
        @TypeConverterQualifier.ListStringTypeConverter
        listStringTypeConverter: Any,
    ): ArtsDataBase =
        Room.databaseBuilder(
            context = context,
            klass = ArtsDataBase::class.java,
            name = ArtsDataBase.DB_NAME
        )
            .addTypeConverter(listStringTypeConverter)
            .fallbackToDestructiveMigration()
            .build()

}