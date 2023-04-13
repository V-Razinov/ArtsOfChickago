package com.example.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui.components.AOCIcons
import com.example.ui.components.ScaleIn

@Composable
internal fun Splash(onFinish: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ScaleIn(delay = 200L, onAnimationFinished = onFinish) {
            Image(
                modifier = Modifier
                    .size(200.dp, 200.dp),
                imageVector = AOCIcons.Splash.imageVector,
                contentDescription = "splash logo"
            )
        }
    }
}