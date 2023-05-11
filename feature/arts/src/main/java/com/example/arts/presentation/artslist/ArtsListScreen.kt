package com.example.arts.presentation.artslist

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.arts.ui.components.AnimatedScrollToTopButton
import com.example.arts.ui.components.ArtCard
import com.example.arts.ui.components.defaultCardImageSize
import com.example.artsdomain.model.ArtListItem
import com.example.ui.components.AOCTopBar
import com.example.ui.components.Loader
import com.example.ui.components.withExtra
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

@Composable
internal fun ArtsListScreen(viewModel: ArtsListViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    ArtsListScreen(
        state = state,
        onArtClick = viewModel::onArtClick,
    )
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun ArtsListScreen(
    state: ArtsListState,
    onArtClick: (art: ArtListItem) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    val lazyArts = state.arts
        .collectAsLazyPagingItems(context = coroutineScope.coroutineContext)
    val lazyListState = rememberLazyListState()

    val showScrollToTopButton by remember {
        derivedStateOf { lazyListState.firstVisibleItemIndex > 2 }
    }
    val onScrollToTopClick = remember {
        { coroutineScope.launch { lazyListState.animateScrollToItem(0) }; Unit }
    }
    var fabSize by remember { mutableStateOf(0) }

    val isRefreshing = lazyArts.loadState.refresh is LoadState.Loading
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = lazyArts::refresh
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        contentColor = MaterialTheme.colorScheme.background,
        topBar = { AOCTopBar(title = "Arts") },
        floatingActionButton = {
            AnimatedScrollToTopButton(
                modifier = Modifier
                    .onSizeChanged { intSize -> fabSize = intSize.height }
                    .testTag(ArtsListTestTags.SCROLL_UP),
                visible = showScrollToTopButton,
                onClick = onScrollToTopClick
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        contentWindowInsets = WindowInsets.systemBars
    ) { paddings ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pullRefresh(pullRefreshState)
        ) {
            val initialLoading = isRefreshing && lazyArts.itemCount == 0
            if (initialLoading) {
                Loading(paddings = paddings)
            } else {
                Arts(
                    arts = lazyArts,
                    paddings = paddings,
                    lazyListState = lazyListState,
                    onArtClick = onArtClick
                )
            }
            if (!initialLoading) {
                PullRefreshIndicator(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(paddings),
                    refreshing = isRefreshing,
                    state = pullRefreshState
                )
            }
        }
    }
}

@Composable
private fun Loading(
    paddings: PaddingValues
) {
    Loader(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddings)
            .testTag(ArtsListTestTags.LOADER),
        imageSize = 128.dp
    )
}

private inline val LoadState.isLoading
    get() = this is LoadState.Loading

private inline val LazyPagingItems<*>.isPrepending
    get() = loadState.prepend == LoadState.Loading ||
            (loadState.refresh.isLoading && itemCount > 0)

private inline val LazyPagingItems<*>.isAppending
    get() = loadState.append == LoadState.Loading

private enum class ArtsViewTypes {
    PREPEND_LOADER,
    ART_CARD,
    APPEND_LOADER
}

@Composable
private fun Arts(
    paddings: PaddingValues,
    arts: LazyPagingItems<ArtListItem>,
    lazyListState: LazyListState,
    onArtClick: (art: ArtListItem) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag(ArtsListTestTags.ARTS_LIST),
        contentPadding = paddings.withExtra(vertical = 16.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = lazyListState,
    ) {
        if (arts.isPrepending) {
            item(
                key = "prepend loader",
                contentType = ArtsViewTypes.PREPEND_LOADER
            ) {
                Loader(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                )
            }
        }
        items(
            arts,
            key = { art -> art.id },
        ) { art ->
            art?.let {
                ArtCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(defaultCardImageSize)
                        .testTag(ArtsListTestTags.ART_CARD),
                    art = art,
                    onCardClick = onArtClick
                )
            }
        }
        if (arts.isAppending) {
            item(
                key = "append loader",
                contentType = ArtsViewTypes.APPEND_LOADER
            ) {
                Loader(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                )
            }
        }
    }
}

// --------- Preview ---------
@Preview(
    showSystemUi = true,
    device = Devices.PHONE
)
@Composable
private fun ArtsListScreenPreview(
    @PreviewParameter(ArtsListScreenPPP::class)
    state: ArtsListState,
) {
    ArtsListScreen(state = state, onArtClick = {})
}

private class ArtsListScreenPPP : PreviewParameterProvider<ArtsListState> {

    private fun randomArtListItem(id: Int) = ArtListItem(
        id = id,
        name = "Random $id",
        authors = "Random $id" + "Random ${id + 1}",
        imageUrl = null
    )

    override val values: Sequence<ArtsListState> =
        sequenceOf(
            ArtsListState(
                arts = flow { emit(PagingData.empty()) }
            ),
            ArtsListState(
                arts = flow { emit(PagingData.from(List(20, ::randomArtListItem))) }
            ),
            ArtsListState(
                arts = flow {
                    emit(
                        PagingData.empty(
                            sourceLoadStates = LoadStates(
                                prepend = LoadState.NotLoading(false),
                                refresh = LoadState.Loading,
                                append = LoadState.NotLoading(false)
                            )
                        )
                    )
                }
            )
        )
}