package com.compose.uiyoutube.ui.screens.home

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.compose.uiyoutube.BoxBackgroundMode
import com.compose.uiyoutube.ColorsBox
import com.compose.uiyoutube.R
import com.compose.uiyoutube.ui.composable.BackPressHandler
import com.compose.uiyoutube.ui.theme.*

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {
    HomeContent()
// Getting your activity in a composable function
    val activity = (LocalContext.current as? Activity)

// Everything put inside this block will be done on each system back press
    BackPressHandler {
        activity?.finish()
    }
}

@Composable
private fun HomeContent(

) {
    val a = Brush.linearGradient(
        colors =    listOf(
            Color(0xFF5995EE).copy(alpha = 0.5f),
            Color.Transparent,
            Color.Transparent

        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(a)
    ) {
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,

                        ColorsBox(
                            BlueViolet1,
                            BlueViolet2,
                            BlueViolet3,
                        )
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,

                        ColorsBox(
                            LightGreen1,
                            LightGreen2,
                            LightGreen3,
                        )
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,

                        ColorsBox(
                            OrangeYellow1,
                            OrangeYellow2,
                            OrangeYellow3,
                        )
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,

                        ColorsBox(
                            Beige1,
                            Beige2,
                            Beige3,
                        )
                    ), Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,

                        ColorsBox(
                            Red1,
                            Red2,
                            Red3,
                        )
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,

                        ColorsBox(
                            Blue1,
                            Blue2,
                            Blue3,
                        )
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,

                        ColorsBox(
                            Orange1,
                            Orange2,
                            Orange3,
                        )
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,

                        ColorsBox(
                            Beige1,
                            Beige2,
                            Beige3,
                        )
                    ), Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,

                        ColorsBox(
                            BlueViolet1,
                            BlueViolet2,
                            BlueViolet3,
                        )
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,

                        ColorsBox(
                            LightGreen1,
                            LightGreen2,
                            LightGreen3,
                        )
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,

                        ColorsBox(
                            OrangeYellow1,
                            OrangeYellow2,
                            OrangeYellow3,
                        )
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,

                        ColorsBox(
                            Beige1,
                            Beige2,
                            Beige3,
                        )
                    )
                )
            )
        }
//        BottomMenu(
//            items = listOf(
//                BottomMenuContent("Home", R.drawable.ic_home),
//                BottomMenuContent("Meditate", R.drawable.ic_bubble),
//                BottomMenuContent("Sleep", R.drawable.ic_moon),
//                BottomMenuContent("Music", R.drawable.ic_music),
//                BottomMenuContent("Profile", R.drawable.ic_profile)
//            ), modifier = Modifier.align(Alignment.BottomCenter),
//
//        ){
//            onItemClick()
//        }

    }
}

@Composable
fun GreetingSection(
    name: String = "Ahmed"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning , $name", style = MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Thin,
                color = TextWhite,
                fontSize = 12.sp
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }

}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .background(
                        if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp)

            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Daily Thought", style = MaterialTheme.typography.h2
            )
            Text(
                text = "Meditation • 3-10 min", style = MaterialTheme.typography.body1,
                color = Color.White,
                fontSize = 12.sp

            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

    }

}

@Composable
fun FeatureSection(features: List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Feature",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it], modifier = Modifier )
            }

        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature,
    modifier: Modifier
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.colorsBox.darkColor)
    )
    {
        BoxBackgroundMode(constraints.maxWidth, constraints.maxHeight, feature.colorsBox)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {

            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = modifier.align(TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )

            Text(
                text = "Start", color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle your click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }


    }

}
























