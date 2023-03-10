package com.compose.uiyoutube.ui.composable.settingScreenComposable

import androidx.compose.foundation.layout.*

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.uiyoutube.ui.screens.search.viewmodel.state.TrendingFeatureState

@Composable
fun SongNameAuthorCard(feature: TrendingFeatureState, IconId: Int, color: Color, modifier: Modifier) {
    Column(horizontalAlignment = Alignment.Start, modifier = modifier) {
        Text(
            text = feature.songName,
            style = MaterialTheme.typography.h2,
            lineHeight = 26.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = IconId),
                contentDescription = "music Icon",
                modifier = Modifier
                    .size(25.dp)
                    .padding(horizontal = 8.dp),
                tint = color
            )
            Text(
                text = feature.songAuthor,

                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = color
            )
        }
    }
}
