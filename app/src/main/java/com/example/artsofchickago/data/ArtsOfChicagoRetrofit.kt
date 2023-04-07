package com.example.artsofchickago.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object ArtsOfChicagoRetrofit {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.artic.edu/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val artOfChicagoApi = retrofit.create(ArtOfChicagoApi::class.java)

}

interface ArtOfChicagoApi {

    @GET("artworks")
    suspend fun getArts(): ArtsDao

    // по аналогии с ArtDao
    @GET("artworks/{artId}")
    suspend fun getArt(@Path("artId") artId: Int): ArtDetailDao

}

data class ArtDetailDao(val data: ArtsDao.Data)