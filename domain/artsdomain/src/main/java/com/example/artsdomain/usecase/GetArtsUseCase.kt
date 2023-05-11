package com.example.artsdomain.usecase

import com.example.artsdata.repository.ArtsOfChicagoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import com.example.artsdomain.mapper.ArtResponseToArtsResultMapper
import com.example.artsdomain.model.ArtsResult
import com.example.dispatchers.AOCDispatchers
import javax.inject.Inject

class GetArtsUseCase @Inject internal constructor(
    private val dispatchers: AOCDispatchers,
    private val artsRepository: ArtsOfChicagoRepository,
    private val artResponseToArtsResultMapper: ArtResponseToArtsResultMapper,
) {

    private companion object {
        const val fields = "id,title,artist_titles,image_id,alt_image_ids"
    }

    operator fun invoke(
        page: Int,
        pageSize: Int,
    ): Flow<ArtsResult> =
        artsRepository.getArts(
            page = page,
            pageSize = pageSize,
            fields = fields
        )
            .map(artResponseToArtsResultMapper::invoke)
            .flowOn(dispatchers.IO)
}
