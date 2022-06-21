package com.example.twittertwo.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color.White,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.Black
)

private val LightColorPalette = lightColors(
    primary = Color.Black,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val DimColorPalette = darkColors(
    primary = Color.White,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = DimBackground
)

@Composable
fun TwitterTwoTheme(darkTheme: Boolean, fullDark: Boolean,  content: @Composable () -> Unit) {
    val darkThemeSelection = if (fullDark){
        DarkColorPalette
    }else{
        DimColorPalette
    }

    val colors = if (darkTheme) {
        darkThemeSelection
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}