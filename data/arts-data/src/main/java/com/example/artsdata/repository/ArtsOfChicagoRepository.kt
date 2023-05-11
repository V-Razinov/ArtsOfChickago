package com.example.artsdata.repository

import com.example.artsdata.model.ArtsResponse
import kotlinx.coroutines.flow.Flow

interface ArtsOfChicagoRepository {

    fun getArts(page: Int, pageSize: Int, fields: String): Flow<ArtsResponse>

}