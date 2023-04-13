package com.example.arts.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ui.components.AOCIcons

@Composable
internal fun ScrollToTopButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        FloatingActionButton(
            shape = FloatingActionButtonDefaults.largeShape,
            elevation = FloatingActionButtonDefaults.loweredElevation(),
            onClick = onClick
        ) {
            Icon(
                imageVector = AOCIcons.ScrollUp.imageVector,
                contentDescription = "scroll up"
            )
        }
    }
}