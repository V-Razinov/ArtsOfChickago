package com.example.ui.components

import androidx.annotation.FloatRange
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import kotlinx.coroutines.delay

@Composable
fun ScaleIn(
    delay: Long = 0L,
    @FloatRange(from = 0.0) initScale: Float = 0f,
    @FloatRange(from = 0.0) targetScale: Float = 1f,
    onAnimationFinished: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    val scale = remember { Animatable(initScale) }
    LaunchedEffect(key1 = delay) {
        delay(delay)
        scale.animateTo(
            targetValue = targetScale,
            animationSpec = tween()
        ) {
            if (this.value >= targetScale) {
                onAnimationFinished()
            }
        }
    }
    Box(modifier = Modifier.scale(scale.value), content = content)
}