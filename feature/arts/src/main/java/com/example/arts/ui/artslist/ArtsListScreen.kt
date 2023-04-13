package com.example.arts.ui.artslist

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.arts.ui.components.AnimatedScrollToTopButton
import com.example.arts.ui.components.ArtCard
import com.example.arts.ui.components.Loader
import com.example.ui.components.AOCTopBar
import com.example.ui.components.withExtra
import kotlinx.coroutines.launch
import team.mediasoft.artsdomain.model.ArtListItem

@Composable
internal fun ArtsListScreen(viewModel: ArtsListViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    ArtsListScreen(
        state = state,
        onArtClick = viewModel::onArtClick
    )
}

@Composable
private fun ArtsListScreen(
    state: ArtsListState,
    onArtClick: (art: ArtListItem) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()

    val showScrollToTopButton by remember {
        derivedStateOf { lazyListState.firstVisibleItemIndex > 2 }
    }
    val onScrollToTopClick = remember {
        { coroutineScope.launch { lazyListState.animateScrollToItem(0) }; Unit }
    }
    var fabSize by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentColor = MaterialTheme.colorScheme.background,
        topBar = { AOCTopBar(title = "Arts") },
        floatingActionButton = {
            AnimatedScrollToTopButton(
                modifier = Modifier.onSizeChanged { intSize -> fabSize = intSize.height },
                visible = showScrollToTopButton,
                onClick = onScrollToTopClick
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        contentWindowInsets = WindowInsets.systemBars
    ) { paddings ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (state.isLoading) {
                Loader(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddings),
                )
                return@Surface
            }

            Arts(
                modifier = Modifier.fillMaxSize(),
                arts = state.arts,
                lazyListState = lazyListState,
                contentPaddings = paddings.withExtra(
                    bottom = LocalDensity.current.run { fabSize.toDp() } + 16.dp
                ),
                onArtClick = onArtClick,
            )
        }
    }
}

private enum class ArtsContentTypes {
    ART
}

@Composable
private fun Arts(
    modifier: Modifier = Modifier,
    arts: List<ArtListItem>,
    lazyListState: LazyListState,
    contentPaddings: PaddingValues,
    onArtClick: (art: ArtListItem) -> Unit,
) {
    Box(modifier = modifier) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = contentPaddings
                .withExtra(vertical = 16.dp, horizontal = 16.dp),
            state = lazyListState,
        ) {
            itemsIndexed(
                items = arts,
                key = { _, art -> art.id },
                contentType = { _, _ -> ArtsContentTypes.ART }
            ) { index, art ->
                ArtCard(art = art, onCardClick = onArtClick)
                if (index < arts.lastIndex) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
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
private fun ArtsListScreenLoadingPreview(
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
            ArtsListState(isLoading = true),
            ArtsListState(
                isLoading = false,
                arts = List(20, ::randomArtListItem)
            )
        )
}