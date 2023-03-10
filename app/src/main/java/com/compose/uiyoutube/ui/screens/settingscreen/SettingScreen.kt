package com.compose.uiyoutube.ui.screens.settingscreen

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.compose.uiyoutube.R
import com.compose.uiyoutube.ui.theme.Rubik
import com.compose.settingscreen.viewModel.SettingViewModel
import com.compose.settingscreen.viewModel.state.SettingUiState
import com.compose.uiyoutube.ui.composable.BackPressHandler
import com.compose.uiyoutube.ui.composable.settingScreenComposable.DefaultBox
import com.compose.uiyoutube.ui.composable.settingScreenComposable.Header
import com.compose.uiyoutube.ui.composable.settingScreenComposable.SettingCard
import com.compose.uiyoutube.ui.composable.spacer.SpacerVertical24
import com.compose.uiyoutube.ui.composable.spacer.SpacerVertical32
import com.compose.uiyoutube.ui.screens.home.HomeScreen
import com.compose.uiyoutube.ui.theme.DeepBlue
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SettingsScreen(
    viewModel: SettingViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsState()
    SettingContent(state)
    BackPressHandler(onBackPressed = { navController.popBackStack("homeScreen", inclusive = false, saveState = false)})
}

@Composable
fun SettingContent(
    state: SettingUiState
) {

    val backGroundColor = if (isSystemInDarkTheme()) DeepBlue else Color.White
    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(backGroundColor)
                .fillMaxSize()
                .padding(horizontal = 25.dp),

            ) {


            Icon(
                imageVector = Icons.Sharp.KeyboardArrowLeft,
                contentDescription = "back to main screen",
                modifier = Modifier
                    .size(40.dp)
                    .offset(x = (-10).dp),
                tint = Color.White
            )


            SpacerVertical24()
            Text(
                text = "Settings",
                fontSize = 40.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = Rubik,
                color = textColor
            )
            SpacerVertical24()
            Text(
                text = "Account",
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Medium,
                fontFamily = Rubik,
                color = textColor
            )
            SpacerVertical32()
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(0.5.dp, Color.Gray, shape = RoundedCornerShape(16.dp))
                    .padding(15.dp),
                elevation = 0.dp,
                backgroundColor = backGroundColor,
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(shape = CircleShape),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.my_photo),
                            contentDescription = null,
                            modifier = Modifier

                                .clip(shape = CircleShape)
                        )
                    }

                    Box(
                        contentAlignment = Center, modifier = Modifier.weight(1f)
                    ) {
                        Header(
                            title = "Ahmed Khater",
                            subtitle = "personal info",
                            modifier = Modifier,
                        )
                    }



                    DefaultBox(40)


                }

            }
            SpacerVertical24()
            Text(
                text = "Settings",
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Normal,
                fontFamily = Rubik,
                color = textColor
            )
            SpacerVertical24()
            LazyColumn(
                modifier = Modifier.fillMaxHeight(),
                contentPadding = PaddingValues(bottom = 100.dp),

                ) {

                items(state.cards) {
                    SettingCard(card = it, backGroundColor, textColor)
                }

            }


        }
    }

}
