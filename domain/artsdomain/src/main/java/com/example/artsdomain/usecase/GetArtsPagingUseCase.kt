package com.example.artsdomain.usecase

import androidx.paging.*
import com.example.artsdata.db.ArtsDataBase
import com.example.artsdomain.mapper.ArtToArtListItemMapper
import com.example.artsdomain.model.ArtListItem
import com.example.dispatchers.AOCDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private const val PAGE_SIZE = 20
private const val INITIAL_LOAD_SIZE = 20
private const val MAX_SIZE = 100

class GetArtsPagingUseCase @Inject constructor(
    private val artsDataBase: ArtsDataBase,
    private val getArtsRemoteMediatorUseCase: GetArtsRemoteMediatorUseCase,
    private val artListItemMapper: ArtToArtListItemMapper,
    private val dispatchers: AOCDispatchers,
) {

    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke(): Flow<PagingData<ArtListItem>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                initialLoadSize = INITIAL_LOAD_SIZE,
                maxSize = MAX_SIZE,
            ),
            remoteMediator = getArtsRemoteMediatorUseCase(),
            pagingSourceFactory = artsDataBase.artsListDao::pagingSource
        )
            .flow
            .map { artsPojo -> artsPojo.map(artListItemMapper::invoke) }
            .flowOn(dispatchers.IO)

}