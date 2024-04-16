package com.example.filmnegar.view.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColorScheme(
    primary = customPrimaryColor,
    background = customPrimaryColor,
    surface = customPrimaryColor,
    secondary = customOnSecondaryColor,
    onSecondary = customOnSecondaryColor,
)

private val LightColorPalette = lightColorScheme(
    primary = customPrimaryColor,
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
    val colors = DarkColorPalette


    MaterialTheme(
        colorScheme  = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(customPrimaryColor)
    systemUiController.setNavigationBarColor(customPrimaryColor)
}