package com.example.filmnegar.view.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = customPrimaryColor,
    primaryVariant = Purple700,
    secondary = customOnSecondaryColor
)

private val LightColorPalette = lightColors(
    primary = customPrimaryColor,
    primaryVariant = Purple700,
    secondary = customSecondaryColor,

    background = customPrimaryColor,
//    surface = Color.White,
//    onPrimary = Color.White,
    onSecondary = customOnSecondaryColor,
//    onBackground = Color.Black,
//    onSurface = Color.Black,

)

@Composable
fun FilmNegarTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(customPrimaryColor)
}