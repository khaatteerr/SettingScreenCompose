package com.compose.settingscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.compose.settingscreen.composable.settingScreenComposable.DefaultBox
import com.compose.settingscreen.composable.settingScreenComposable.Header
import com.compose.settingscreen.composable.settingScreenComposable.SettingCard
import com.compose.settingscreen.composable.spacer.SpacerVertical24
import com.compose.settingscreen.composable.spacer.SpacerVertical32
import com.compose.settingscreen.ui.theme.Rubik
import com.compose.settingscreen.viewModel.SettingViewModel
import com.compose.settingscreen.viewModel.state.SettingUiState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SettingsScreen(
    viewModel: SettingViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    SettingContent(state)
}

@Composable
fun SettingContent(
    state: SettingUiState
) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Color.White, darkIcons = true)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 25.dp)

    ) {


        Icon(
            imageVector = Icons.Sharp.KeyboardArrowLeft,
            contentDescription = "back to main screen",
            modifier = Modifier
                .size(40.dp)
                .offset(x = (-10).dp)
        )


        SpacerVertical24()
        Text(
            text = "Settings",
            fontSize = 40.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.fillMaxWidth(),
            fontFamily = Rubik
        )
        SpacerVertical24()
        Text(
            text = "Account",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Medium,
            fontFamily = Rubik,
            color = Color.Gray
        )
        SpacerVertical32()
        Card(
            modifier = Modifier.fillMaxWidth(), elevation = 0.dp, shape = RoundedCornerShape(16.dp)

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
                        painter = painterResource(id = com.compose.settingscreen.R.drawable.my_photo),
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
        )
        SpacerVertical24()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

        ) {

            items(state.cards) {
                SettingCard(card = it)
            }

        }


    }
}
