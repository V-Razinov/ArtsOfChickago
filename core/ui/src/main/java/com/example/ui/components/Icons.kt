package com.example.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.ui.R
import com.example.ui.components.AOCIcon.DrawableResourceIcon
import com.example.ui.components.AOCIcon.ImageVectorIcon

sealed interface AOCIcon {
    data class ImageVectorIcon(val imageVector: ImageVector) : AOCIcon
    data class DrawableResourceIcon(@DrawableRes val id: Int) : AOCIcon
}

object AOCIcons {
    val Reload by lazy { ImageVectorIcon(Icons.Rounded.Refresh) }
    val NoImage by lazy { DrawableResourceIcon(R.drawable.ic_no_image) }
    val Splash by lazy { ImageVectorIcon(Icons.Rounded.Build) }
    val ScrollUp by lazy { ImageVectorIcon(Icons.Rounded.KeyboardArrowUp) }
    val ArrowBack by lazy { ImageVectorIcon(Icons.Rounded.ArrowBack) }
}

// ----- Preview -----

private class AOCIconsProvider : PreviewParameterProvider<AOCIcon> {
    override val values: Sequence<AOCIcon> = sequenceOf(
        AOCIcons.Reload,
        AOCIcons.NoImage,
        AOCIcons.Splash,
        AOCIcons.ScrollUp,
        AOCIcons.ArrowBack,
    )
}

@Preview
@Composable
private fun IconsPreview(
    @PreviewParameter(AOCIconsProvider::class)
    icon: AOCIcon,
) {
    when (icon) {
        is DrawableResourceIcon -> Icon(
            painter = painterResource(id = icon.id),
            contentDescription = null
        )
        is ImageVectorIcon -> Icon(
            imageVector = icon.imageVector,
            contentDescription = null
        )
    }
}