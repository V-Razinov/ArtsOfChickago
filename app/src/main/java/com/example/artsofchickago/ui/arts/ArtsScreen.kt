package com.example.artsofchickago.ui.arts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.artsofchicago.di.Art

@Composable
fun ArtsScreen(viewModel: ArtsViewModel = hiltViewModel()) {
    val artsState by viewModel.artsState.collectAsState()
    ArtsScreen(
        artsState = artsState,
        onArtClick = viewModel::onArtClick
    )
}

@Composable
private fun ArtsScreen(
    artsState: ArtsState,
    onArtClick: (Art) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(artsState.arts) { art ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clickable { onArtClick(art) }
            ) {
                Row(modifier = Modifier) {
                    AsyncImage(
                        modifier = Modifier.size(100.dp),
                        model = art.image,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                    Column {
                        Text(text = art.name)
                        Text(text = art.authors)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

    if (artsState.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(modifier = Modifier.size(48.dp))
        }
    }
}