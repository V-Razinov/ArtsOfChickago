package com.example.artsofchickago.ui.artdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ArtDetails(viewModel: ArtDetailsViewModel) {
    val state by viewModel.state.collectAsState()
    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(top = 24.dp)
                .padding(horizontal = 16.dp)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = state.image,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "id: ${state.id}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = state.name)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = state.authors)
        }
    }
}