package com.example.project.data.bottomBar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBar(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
    val route: String
)