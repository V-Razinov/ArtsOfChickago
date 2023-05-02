package com.example.artsdata.api

import com.example.artsdata.model.ArtsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtsOfChicagoApi {

    @GET("artworks")
    suspend fun getArts(
        @Query("page") page: Int,
        @Query("limit") pageSize: Int,
        @Query("fields") fields: String// id,title....
    ): ArtsResponse

//    fun getArtById(id: Int): Art? = null
}