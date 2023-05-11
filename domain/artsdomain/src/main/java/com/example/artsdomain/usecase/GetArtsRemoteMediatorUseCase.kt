package com.example.artsdomain.usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.artsdata.db.ArtsDataBase
import com.example.artsdata.model.ArtPojo
import com.example.artsdata.model.ArtsResponse
import com.example.artsdata.repository.ArtsOfChicagoRepository
import com.example.artsdomain.mapper.ArtToArtListItemMapper
import com.example.artsdomain.mapper.PaginationMapper
import kotlinx.coroutines.flow.firstOrNull
import java.util.concurrent.CancellationException
import javax.inject.Inject

class GetArtsRemoteMediatorUseCase @Inject internal constructor(
    private val getArtsUseCase: GetArtsUseCase,
    private val artsRepository: ArtsOfChicagoRepository,
    private val dataBase: ArtsDataBase,
    private val artToArtListItemMapper: ArtToArtListItemMapper,
    private val paginationMapper: PaginationMapper,
) {

    @ExperimentalPagingApi
    operator fun invoke(): RemoteMediator<Int, ArtPojo> =
        object : RemoteMediator<Int, ArtPojo>() {

            private var page = 1

            override suspend fun load(
                loadType: LoadType,
                state: PagingState<Int, ArtPojo>,
            ): MediatorResult = runCatching {
                page = when (loadType) {
                    LoadType.REFRESH -> 1
                    LoadType.PREPEND -> (page - 1).takeIf { it >= 1 }
                    LoadType.APPEND -> (page + 1)
                } ?: return@runCatching MediatorResult.Success(endOfPaginationReached = true)

                val response = requestArts(page, state)
                    ?: return@runCatching MediatorResult.Error(noResponseException)

                val arts = response.data
                dataBase.withTransaction {
                    if (loadType == LoadType.REFRESH && page == 1) {
                        dataBase.artsListDao.clear()
                    }
                    dataBase.artsListDao.insert(arts)
                }
                val pagingInfo = paginationMapper(response.pagination)
                return@runCatching MediatorResult.Success(
                    endOfPaginationReached = pagingInfo.currentPage >= pagingInfo.totalPages
                )
            }.getOrElse { t ->
                if (t is CancellationException) {
                    throw t
                }
                MediatorResult.Error(t)
            }

        }

    private val PagingState<Int, *>.closestPagePrevKey: Int?
        get() = this.anchorPosition
            ?.let(::closestPageToPosition)
            ?.prevKey
            ?.takeIf { it >= 1 }

    private val PagingState<Int, *>.closestPageNextKey: Int?
        get() = this.anchorPosition
            ?.let(::closestPageToPosition)
            ?.nextKey

    private val noResponseException: Exception
        get() = NullPointerException("response is null")

    private suspend fun requestArts(
        nextPage: Int,
        state: PagingState<Int, ArtPojo>,
    ): ArtsResponse? =
        artsRepository.getArts(
            page = nextPage,
            pageSize = state.config.pageSize,
            fields = "id,title,artist_titles,image_id,alt_image_ids"
        ).firstOrNull()
}