package com.compose.uiyoutube.ui.screens.search

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.compose.uiyoutube.R
import com.compose.uiyoutube.ui.composable.settingScreenComposable.SongNameAuthorCard
import com.compose.uiyoutube.ui.screens.search.viewmodel.state.TrendingFeatureState

@SuppressLint("RememberReturnType")
@Composable
fun TrendingFeatureItem(feature: TrendingFeatureState, onClick: (TrendingFeatureState) -> Unit) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(start = 15.dp, end = 8.dp)
            .aspectRatio(1.3f)
            .clip(RoundedCornerShape(30.dp))
            .clickable { onClick(feature) }

    )
    {
        var borderState by remember {
            mutableStateOf(Color.Transparent)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .border(1.dp, borderState, RoundedCornerShape(30.dp))

        ) {
            val imagePainter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(feature.backgroundImageId)
                    .crossfade(true)
//                    .diskCachePolicy(CachePolicy.DISABLED)
//                    .memoryCachePolicy(CachePolicy.DISABLED)
                    .build(),
            )
            val showImage = remember {
                mutableStateOf(true)
            }
            val linearGradientBrush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF5995EE),
                    Color(0xFFB226E1),
                    Color(0xFFE28548)
                ),

                start = Offset(Float.POSITIVE_INFINITY, 0f),
                end = Offset(0f, Float.POSITIVE_INFINITY),
            )

            if (showImage.value) {
                borderState  = Color.Transparent
                Image(
                    painter = imagePainter,
                    contentDescription = "my photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            when (imagePainter.state) {
                is AsyncImagePainter.State.Loading -> {
                    borderState  = Color.White.copy(alpha = 0.5f)
                    showImage.value = true
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        CircularProgressIndicator(
                            modifier = Modifier,
                            strokeWidth = 2.dp,
                            color = Color.White
                        )
                    }

                }
                is AsyncImagePainter.State.Error -> {
                    borderState  = Color.White.copy(alpha = 0.5f)
                    showImage.value = true
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Error Here",
                            modifier = Modifier,
                            tint = Color.White
                        )}

                }
                else -> {
                    showImage.value = true
                }
            }

            Icon(
                painter = painterResource(id = R.drawable.options_svgrepo_com),
                contentDescription = "song option",
                tint = Color.White,
                modifier = Modifier
                    .padding(30.dp, vertical = 10.dp)
                    .align(Alignment.TopEnd)
                    .size(20.dp)

            )

            Card(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(linearGradientBrush, alpha = 0.6f)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, top = 5.dp, bottom = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    SongNameAuthorCard(
                        feature = feature,
                        R.drawable.ic_music,
                        Color.White,
                        modifier = Modifier
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = "play icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 8.dp)
                    )
                }

            }

        }
    }

}