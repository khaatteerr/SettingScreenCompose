package com.compose.uiyoutube.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.compose.uiyoutube.ColorsBox

data class Feature(
    val title:String,
    @DrawableRes val iconId :Int,
    val colorsBox: ColorsBox,
)
