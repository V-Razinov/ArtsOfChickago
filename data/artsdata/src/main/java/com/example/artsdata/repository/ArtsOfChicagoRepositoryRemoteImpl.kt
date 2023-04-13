package com.example.artsdata.repository

import com.example.artsdata.model.ArtsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class ArtsOfChicagoRepositoryRemoteImpl(
    private val artsOfChicagoService: ArtsOfChicagoApi,
) : ArtsOfChicagoRepository {

    override fun getArts(
        page: Int,
        pageSize: Int,
        fields: String,
    ): Flow<ArtsResponse> = flow {
        emit(artsOfChicagoService.getArts(page = page, pageSize = pageSize, fields = fields))
    }

}