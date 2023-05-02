package com.example.arts.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.ui.addIf
import com.example.ui.components.AOCIcons
import com.example.artsdomain.model.ArtListItem

internal val defaultCardImageSize = 100.dp

@Preview
@Composable
private fun ArtCardPreview() {
    ArtCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(defaultCardImageSize),
        art = ArtListItem(
            id = 1,
            name = "Preview name",
            authors = "Preview Authors",
            imageUrl = null
        ),
        onCardClick = { }
    )
}

@Composable
internal fun ArtCard(
    modifier: Modifier = Modifier,
    art: ArtListItem,
    onCardClick: ((art: ArtListItem) -> Unit)? = null,
) {
    Card(
        modifier = Modifier
            .addIf(onCardClick != null) {
                clickable { onCardClick?.invoke(art) }
            }
            .then(modifier),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(art)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp, horizontal = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = art.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = art.authors,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun Image(art: ArtListItem) {
    if (art.imageUrl.isNullOrEmpty()) {
        NoImage(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
        )
        return
    }

    SubcomposeAsyncImage(
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1f),
        model = ImageRequest.Builder(LocalContext.current)
            .data(art.imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = "art image"
    ) {
        when (painter.state) {
            is AsyncImagePainter.State.Success ->
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painter,
                    contentScale = ContentScale.Crop,
                    contentDescription = "art image"
                )
            is AsyncImagePainter.State.Error ->
                ImageError(onReloadClick = {
                    painter.onForgotten()
                    painter.onRemembered()
                })
            AsyncImagePainter.State.Empty ->
                NoImage()
            is AsyncImagePainter.State.Loading ->
                ImageLoading()
        }
    }
}

@Composable
private fun ImageLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(24.dp),
        )
    }
}

@Composable
private fun NoImage(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = AOCIcons.NoImage.id),
            contentDescription = "no image"
        )
    }
}

@Composable
private inline fun ImageError(crossinline onReloadClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = { onReloadClick() }),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = AOCIcons.Reload.imageVector,
            contentDescription = "reload art"
        )
        Text(text = "failed to load", style = MaterialTheme.typography.labelSmall)
    }
}