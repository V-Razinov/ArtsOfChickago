package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui.theme.AOCTheme
import java.io.IOException

private const val unknownError = "Whoops, something went wrong("

@Composable
fun AOCError(
    modifier: Modifier,
    error: Throwable,
    imageModifier: Modifier = Modifier.size(200.dp),
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val errorText = remember {
            (error.localizedMessage ?: error.message)
                ?.ifEmpty { unknownError }
                ?: unknownError
        }
        AsyncImage(
            modifier = imageModifier,
            model = AOCIcons.Error,
            imageLoader = gifLoader(),
            contentDescription = "error"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = errorText,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(
//    showBackground = true,
    showSystemUi = true,
)
@Composable
fun AOCErrorPreview() {
    val error = IOException()
    AOCTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val errorText = remember {
                    (error.localizedMessage ?: error.message)
                        ?.ifEmpty { unknownError }
                        ?: unknownError
                }
                Image(
                    modifier = Modifier.size(200.dp),
                    painter = painterResource(id = AOCIcons.Error.id),
                    contentDescription = "error"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = errorText,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}