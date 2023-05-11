package com.example.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

private data class PreviewInput(
    val name: String,
    val style: TextStyle,
)

@Preview(
    widthDp = 1080,
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun TypographyPreview() {
    AOCTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            val styles = listOf(
                "displayLarge" to MaterialTheme.typography.displayLarge,
                "displayMedium" to MaterialTheme.typography.displayMedium,
                "displaySmall" to MaterialTheme.typography.displaySmall,
                "headlineLarge" to MaterialTheme.typography.headlineLarge,
                "headlineMedium" to MaterialTheme.typography.headlineMedium,
                "headlineSmall" to MaterialTheme.typography.headlineSmall,
                "titleLarge" to MaterialTheme.typography.titleLarge,
                "titleMedium" to MaterialTheme.typography.titleMedium,
                "titleSmall" to MaterialTheme.typography.titleSmall,
                "bodyLarge" to MaterialTheme.typography.bodyLarge,
                "bodyMedium" to MaterialTheme.typography.bodyMedium,
                "bodySmall" to MaterialTheme.typography.bodySmall,
                "labelLarge" to MaterialTheme.typography.labelLarge,
                "labelMedium" to MaterialTheme.typography.labelMedium,
                "labelSmall" to MaterialTheme.typography.labelSmall,
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                styles.forEach { style ->
                    Text(
                        text = style.first + " " + style.second.fontSize,
                        style = style.second
                    )
                }
            }
        }
    }
}