package com.example.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp

val AOCTopBaseHeight = 56.dp
val AOCTopBarDefaultIconSize = 24.dp

private class AOCTopBarPPP : PreviewParameterProvider<AOCTopBarPPP.Params> {
    class Params(
        val navIcon: AOCIcon?,
        val title: String,
    )

    override val values: Sequence<Params> = sequenceOf(
        Params(navIcon = null, title = "Short"),
        Params(navIcon = AOCIcons.ArrowBack, title = "Short"),
        Params(navIcon = null, title = "Looooooooooooooooooooooooooooong"),
        Params(navIcon = AOCIcons.ArrowBack, title = "Looooooooooooooooooooooooooooong"),
    )
}

@Preview(
    widthDp = 320
)
@Composable
private fun AOCTopBarPreview(
    @PreviewParameter(AOCTopBarPPP::class)
    params: AOCTopBarPPP.Params,
) {
    AOCTopBar(
        navigationIcon = params.navIcon,
        title = params.title,
    )
}

@Composable
fun AOCTopBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentPadding: PaddingValues = StatusBarsPaddingValues(),
    navigationIcon: AOCIcon? = null,
    onNavigationIconClick: (() -> Unit)? = null,
    title: String = "",
) {
    TopAppBar(
        modifier = modifier
            .height(AOCTopBaseHeight + contentPadding.calculateTopPadding())
            .fillMaxWidth(),
        backgroundColor = backgroundColor,
        contentPadding = contentPadding,
    ) {
        if (navigationIcon != null) {
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(
                onClick = { onNavigationIconClick?.invoke() }
            ) {
                val iconModifier = Modifier
                    .size(AOCTopBarDefaultIconSize)
                when (navigationIcon) {
                    is AOCIcon.DrawableResourceIcon -> {
                        Icon(
                            modifier = iconModifier,
                            painter = painterResource(id = navigationIcon.id),
                            contentDescription = "navigation icon"
                        )
                    }
                    is AOCIcon.ImageVectorIcon -> Icon(
                        modifier = iconModifier,
                        imageVector = navigationIcon.imageVector,
                        contentDescription = "navigation icon"
                    )
                }
            }
        }
        if (title.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(
                        start = when (navigationIcon) {
                            null -> 16.dp
                            else -> 12.dp
                        },
                        end = 16.dp,
                    ),
                text = title,
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}