package team.mediasoft.artsdomain.usecase

import com.example.artsdata.model.ArtsResponse
import com.example.artsdata.model.common.Pagination
import com.example.artsdata.repository.ArtsOfChicagoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import team.mediasoft.artsdomain.model.ArtListItem
import javax.inject.Inject

class GetArtsUseCase @Inject constructor(
    private val repositoryRemote: ArtsOfChicagoRepository,
) {

    private companion object {
        const val fields = "id,title,artist_titles,image_id,alt_image_ids"
    }

    operator fun invoke(
        page: Int,
        pageSize: Int,
    ): Flow<Result> =
        repositoryRemote.getArts(
            page = page,
            pageSize = pageSize,
            fields = fields
        ).map { response -> response.toResult() }

    private fun ArtsResponse.toResult(): Result =
        Result(
            pagingInfo = this.pagination.toPagingInfo(),
            arts = this.data.toArtListItems()
        )

    private fun Pagination.toPagingInfo(): Result.PagingInfo =
        Result.PagingInfo(
            totalPages = this.total_pages,
            currentPage = this.current_page,
            totalItems = this.total
        )

    private fun List<ArtsResponse.Art>.toArtListItems(): List<ArtListItem> =
        this.map {
            ArtListItem(
                id = it.id,
                name = it.title,
                authors = it.artist_titles.joinToString(separator = ", "),
                imageUrl = when (val id = it.image_id ?: it.alt_image_ids.firstOrNull()) {
                    null -> null
                    else -> "https://www.artic.edu/iiif/2/${id}/full/100,/0/default.jpg"
                }
            )
        }

    data class Result(
        val pagingInfo: PagingInfo,
        val arts: List<ArtListItem>,
    ) {
        class PagingInfo(
            val totalPages: Int,
            val currentPage: Int,
            val totalItems: Int,
        )
    }
}
