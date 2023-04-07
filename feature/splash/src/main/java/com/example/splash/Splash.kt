package com.example.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.ui.components.ScaleIn


@Composable
fun Splash(onFinish: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ScaleIn(delay = 200L, onAnimationFinished = onFinish) {
//            Image(
//                modifier = Modifier
//                    .size(200.dp, 200.dp),
//                painter = painterResource(id = R.drawable.ic_brush_24),
//                contentDescription = "splash logo"
//            )
        }
    }
}