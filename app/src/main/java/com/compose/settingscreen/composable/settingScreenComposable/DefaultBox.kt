package com.compose.settingscreen.composable.settingScreenComposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.compose.settingscreen.ui.theme.CardBackgroundColor

@Composable
fun DefaultBox(iconSize : Int){
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier.clip(RoundedCornerShape(16.dp))
    ) {
        Icon(
            imageVector = Icons.Sharp.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier
                .background(CardBackgroundColor)
                .padding(8.dp)
                .size(iconSize.dp)
        )
    }
}