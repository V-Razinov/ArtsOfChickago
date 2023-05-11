@file:SuppressLint("ComposableNaming")

package com.example.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PaddingValues.withExtra(
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp,
): PaddingValues = PaddingValues(
    start = calculateStartPadding(LocalLayoutDirection.current) + start,
    top = calculateTopPadding() + top,
    end = calculateEndPadding(LocalLayoutDirection.current) + end,
    bottom = calculateBottomPadding() + bottom
)

@Composable
fun PaddingValues.withExtra(
    vertical: Dp = 0.dp,
    horizontal: Dp = 0.dp,
): PaddingValues = this.withExtra(
    start = horizontal,
    top = vertical,
    end = horizontal,
    bottom = vertical
)

@Composable
fun PaddingValues.withExtra(
    paddings: Dp = 0.dp,
): PaddingValues = this.withExtra(
    start = paddings,
    top = paddings,
    end = paddings,
    bottom = paddings
)

//--------------- Insets ---------------

@Composable
fun InsetsPaddingValues(
    extraStart: Dp = 0.dp,
    extraTop: Dp = 0.dp,
    extraEnd: Dp = 0.dp,
    extraBottom: Dp = 0.dp,
    type: WindowInsets,
): PaddingValues =
    type.asPaddingValues(LocalDensity.current)
        .withExtra(
            start = extraStart,
            top = extraTop,
            end = extraEnd,
            bottom = extraBottom,
        )

//--------------- System Bars ---------------

@Composable
fun SystemBarPaddingValues(
    extraStart: Dp = 0.dp,
    extraTop: Dp = 0.dp,
    extraEnd: Dp = 0.dp,
    extraBottom: Dp = 0.dp,
): PaddingValues = InsetsPaddingValues(
    extraStart = extraStart,
    extraTop = extraTop,
    extraEnd = extraEnd,
    extraBottom = extraBottom,
    type = WindowInsets.systemBars
)

@Composable
fun SystemBarPaddingValues(
    extraPaddings: Dp,
): PaddingValues = SystemBarPaddingValues(
    extraStart = extraPaddings,
    extraTop = extraPaddings,
    extraEnd = extraPaddings,
    extraBottom = extraPaddings
)

@Composable
fun SystemBarPaddingValues(
    extraVertical: Dp = 0.dp,
    extraHorizontal: Dp = 0.dp,
): PaddingValues = SystemBarPaddingValues(
    extraStart = extraHorizontal,
    extraTop = extraVertical,
    extraEnd = extraHorizontal,
    extraBottom = extraVertical
)

//--------------- Status Bar  ---------------

@Composable
fun StatusBarsPaddingValues(
    extraStart: Dp = 0.dp,
    extraTop: Dp = 0.dp,
    extraEnd: Dp = 0.dp,
    extraBottom: Dp = 0.dp,
): PaddingValues = InsetsPaddingValues(
    extraStart,
    extraTop,
    extraEnd,
    extraBottom,
    WindowInsets.statusBars
)

@Composable
fun StatusBarsPaddingValues(
    extraPaddings: Dp,
): PaddingValues = StatusBarsPaddingValues(
    extraStart = extraPaddings,
    extraTop = extraPaddings,
    extraEnd = extraPaddings,
    extraBottom = extraPaddings
)

@Composable
fun StatusBarsPaddingValues(
    extraVertical: Dp = 0.dp,
    extraHorizontal: Dp = 0.dp,
): PaddingValues = StatusBarsPaddingValues(
    extraStart = extraHorizontal,
    extraTop = extraVertical,
    extraEnd = extraHorizontal,
    extraBottom = extraVertical
)

//--------------- Navigation bar ---------------

@Composable
fun NavigationBarsPaddingValue(
    extraStart: Dp = 0.dp,
    extraTop: Dp = 0.dp,
    extraEnd: Dp = 0.dp,
    extraBottom: Dp = 0.dp,
): PaddingValues = InsetsPaddingValues(
    extraStart,
    extraTop,
    extraEnd,
    extraBottom,
    WindowInsets.navigationBars
)

@Composable
fun NavigationBarsPaddingValue(
    extraPaddings: Dp,
): PaddingValues = NavigationBarsPaddingValue(
    extraStart = extraPaddings,
    extraTop = extraPaddings,
    extraEnd = extraPaddings,
    extraBottom = extraPaddings
)

@Composable
fun NavigationBarsPaddingValue(
    extraVertical: Dp = 0.dp,
    extraHorizontal: Dp = 0.dp,
): PaddingValues = NavigationBarsPaddingValue(
    extraStart = extraHorizontal,
    extraTop = extraVertical,
    extraEnd = extraHorizontal,
    extraBottom = extraVertical
)