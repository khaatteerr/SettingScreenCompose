package com.compose.uiyoutube.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomMenuContent(
    val title:String,
    val route: String,
    @DrawableRes val iconId: Int = 0

)
