package com.example.cinepeek.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

private val DarkColors = darkColorScheme(
    primary = Color(0xFFBB86FC),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.Black,
    onBackground = Color.White
)

private val LightColors = lightColorScheme(
    primary = Color(0xFF6200EE),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFF2F2F2),
    onPrimary = Color.White,
    onBackground = Color.Black
)

val CinePeekTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = MontserratFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    titleMedium = TextStyle(
        fontFamily = MontserratFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    titleLarge = TextStyle(
        fontFamily = MontserratFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
)

@Composable
fun CinePeekTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) { DarkColors }
    else { LightColors }
    MaterialTheme(
        colorScheme = colors,
        typography = CinePeekTypography,
        content = content
    )
}
