package com.compose.uiyoutube.ui.screens.search

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.compose.uiyoutube.R
import com.compose.uiyoutube.ui.composable.BackPressHandler
import com.compose.uiyoutube.ui.composable.settingScreenComposable.SongNameAuthorCard
import com.compose.uiyoutube.ui.screens.search.viewmodel.SearchViewModel
import com.compose.uiyoutube.ui.screens.search.viewmodel.state.SearchUiState
import com.compose.uiyoutube.ui.screens.search.viewmodel.state.SongCategoryState
import com.compose.uiyoutube.ui.screens.search.viewmodel.state.TrendingFeatureState
import com.compose.uiyoutube.ui.theme.*

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsState()
    SearchContent(state)
    BackPressHandler(onBackPressed = {
        navController.popBackStack(
            "homeScreen",
            inclusive = false,
            saveState = false
        )
    })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun SearchContent(state: SearchUiState) {


    val listState = rememberLazyListState()

    var hideItemState by remember {
        mutableStateOf(false)
    }


    var colorState by remember {
        mutableStateOf(
            listOf(
                Color(0xFF5995EE).copy(alpha = 0.5f),
                Transparent,
                Transparent

            )
        )
    }

    val colors = listOf(
        DeepBlue,
        Red3,
        DeepBlue,
        LightGreen1,
        LightGreen2,
        LightGreen3,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3,
        Red1,
        Red2,
        Red3,
        Blue1,
        Blue2,
        Blue3,
        Orange1,
        Orange2,
        Orange3,
    )
    val linearGradientBrush = Brush.linearGradient(
        colors = colorState,
//        listOf(
//
//            Color(0xFF5995EE).copy(alpha = 0.5f),
//            Color.Transparent,
//            Color.Transparent
////            Color(0xFFB226E1),
////            Color(0xFFE28548)
//        ),

        start = Offset(Float.POSITIVE_INFINITY, 0f),
        end = Offset(0f, Float.POSITIVE_INFINITY),
    )


    val _linearGradientBrush = Brush.linearGradient(
        colors = if (hideItemState) listOf(
            colors.random(),
            colors.random()
        ) else listOf(colors.random(), colors.random()),
        start = Offset(Float.POSITIVE_INFINITY, 0f),
        end = Offset(0f, Float.POSITIVE_INFINITY),
    )
    val searchFieldNoBackground = Brush.linearGradient(
        colors =
        listOf(
            Transparent,
            Transparent,
            Transparent,
        )
    )

    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = colors.distinct().random()
        , targetValue =colors.distinct().random()
        , animationSpec = InfiniteRepeatableSpec(tween(5000) , repeatMode = RepeatMode.Reverse) ,
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(linearGradientBrush)

    ) {

        Column {


            LazyColumn(state = listState) {

                item {
                    Text(
                        text = "Search",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .padding(vertical = 20.dp, horizontal = 15.dp),
                        color = White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }

                stickyHeader {

                    Box(
                        Modifier
                            .fillParentMaxWidth()
                            .clip(RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp))
                            .background(
                          //          if (hideItemState) color else Transparent)
                                brush = (if (hideItemState) _linearGradientBrush else searchFieldNoBackground)
                            )

                    ) {
                        SearchField()
                    }

                    //  color =  if (hideItemState)  ButtonBlue else Transparent,


                }
                item {
                    TrendingSection(trendingFeature = state.trendingFeature!!) {

                    }
                }
                item {
                    RecentSearches(feature = state.trendingFeature!![2])
                }
                items(count = 3) {
                    GenresSection(
                        featureName = state.featureName[it],
                        category = when (it) {
                            0 -> state.genres!!
                            1 -> state.songCategory!!
                            else -> {
                                state.podcastByCategory!!
                            }
                        },
                        modifier = if (it == 2) Modifier.padding(bottom = 80.dp) else Modifier
                    )
                }

            }
        }

    }
    LaunchedEffect(key1 = listState) {
        snapshotFlow { listState.firstVisibleItemIndex }.collect {
            Log.i("khaterLog", it.toString())

            val list = listOf(0.1f, 0.2f, 0.23f)
            hideItemState = it == 1 || it + 1 == 3 || it + 2 == 5

        }
    }
}

@Composable
private fun SearchField() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)

    ) {
        var textInput by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(ButtonBlue.copy(alpha = 0.2f))

        ) {

            Icon(
                painter = painterResource(id = R.drawable.menu2_svgrepo_com),
                contentDescription = "searchMenu",
                tint = White,
                modifier = Modifier
                    .size(24.dp)
                    .align(Center)
            )
        }

        OutlinedTextField(
            value = textInput,
            onValueChange = {
                textInput = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = White,
                unfocusedBorderColor = Gray.copy(alpha = 0.5f),
                cursorColor = White,
                textColor = White
            ),
            placeholder = {
                Text(
                    text = "Search",
                    color = TextWhite,
                    fontSize = 15.sp,
                    fontFamily = Rubik,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 1.dp)
                )
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(ButtonBlue.copy(alpha = 0.2f))
                .height(50.dp),
            shape = RoundedCornerShape(15.dp),

            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search icon text field",
                    tint = White,
                    modifier = Modifier
                        .size(18.dp)
                )
            },


            )


    }

}

@Composable
private fun TrendingSection(
    trendingFeature: List<TrendingFeatureState>,

    onClick: (TrendingFeatureState) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(
                text = "Trending right now",
                style = MaterialTheme.typography.body1,
                modifier = Modifier,
                color = White,
                fontWeight = FontWeight.Medium,
                fontSize = 28.sp
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            items(trendingFeature.size) {
                Column(
                    modifier = Modifier.width(250.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TrendingFeatureItem(feature = trendingFeature[it], onClick = onClick)
                }
            }
        }

    }

}

@Composable
private fun RecentSearches(feature: TrendingFeatureState) {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 40.dp, end = 15.dp, bottom = 10.dp)
    ) {
        Text(
            text = "Recent searches",
            color = White,
            fontSize = 20.sp,
            fontFamily = Rubik,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            var favState by remember {
                mutableStateOf(false)
            }
            val isFavorite by remember {
                derivedStateOf {
                    if (favState) Red else White
                }
            }
            Image(
                painter = rememberAsyncImagePainter(model = feature.backgroundImageId),
                contentDescription = "song image",
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            SongNameAuthorCard(feature, R.drawable.ic_profile, Gray, modifier = Modifier.weight(1f))
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier
            ) {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Default.Favorite),
                    contentDescription = "favorite icon",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterEnd)
                        .clickable {
                            favState = !favState
                        },
                    tint = isFavorite
                )
            }

        }
    }

}

@Composable
private fun GenresSection(
    featureName: String,
    category: List<SongCategoryState>,
    modifier: Modifier
) {
    Column(modifier = Modifier.fillMaxHeight()) {
        Text(
            text = featureName,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 20.dp),
            modifier = modifier.fillMaxWidth()
        ) {
            items(category.size) {
                Column(
                    modifier = Modifier.width(250.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CategoryItem(category[it])
                }

            }

        }

    }
}

