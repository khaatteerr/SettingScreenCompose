package com.compose.uiyoutube.ui.screens.search.viewmodel.state

import androidx.annotation.DrawableRes
import com.compose.uiyoutube.ColorsBox

data class TrendingFeatureState(
    val songName : String= "",
    val songAuthor:String="",
    val backgroundImageId :String="",
    val colorsBox: ColorsBox?=null,
)


