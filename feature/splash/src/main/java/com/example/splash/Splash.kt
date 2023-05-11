package com.example.splash

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.ui.addIf
import com.example.ui.components.AOCIcons
import com.example.ui.components.ScaleIn

@Composable
internal fun Splash(onFinish: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ScaleIn(delay = 200L, onAnimationFinished = onFinish) {
//            Image(
//                modifier = Modifier
//                    .size(200.dp, 200.dp),
//                imageVector = AOCIcons.Splash.imageVector,
//                contentDescription = "splash logo"
//            )
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                model = AOCIcons.DrLivesey.id,
                imageLoader = ImageLoader.Builder(LocalContext.current)
                    .components {
                        if (Build.VERSION.SDK_INT >= 28) {
                            add(ImageDecoderDecoder.Factory())
                        } else {
                            add(GifDecoder.Factory())
                        }
                    }
                    .build(),
                contentDescription = "loader"
            )
        }
    }
}