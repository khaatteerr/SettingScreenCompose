package com.compose.uiyoutube.ui.screens.search.viewmodel.state

import androidx.compose.ui.graphics.Color
import com.compose.uiyoutube.ColorsBox

data class SongCategoryState(val categoryName : String, val colorsBox: ColorsBox? = ColorsBox(
    Color(0xFF5995EE),
    Color(0xFFB226E1),
    Color(0xFFE28548)
) , val background : String?)
