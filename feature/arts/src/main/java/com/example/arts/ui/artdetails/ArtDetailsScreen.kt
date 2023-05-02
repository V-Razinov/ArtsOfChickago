package com.example.arts.ui.artdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ui.components.AOCIcons
import com.example.ui.components.AOCTopBar

@Composable
internal fun ArtDetailsScreen(viewModel: ArtDetailsViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    ArtDetailsScreen(
        state = state,
        onBackClick = viewModel::onBackClick,
    )
}

@Composable
private fun ArtDetailsScreen(
    state: ArtDetailsState,
    onBackClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AOCTopBar(
                title = "Details",
                navigationIcon = AOCIcons.ArrowBack,
                onNavigationIconClick = onBackClick
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = state.id.toString(),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}