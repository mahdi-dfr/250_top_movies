package com.example.filmnegar.utils

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val route : String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
)
