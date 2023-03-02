package com.compose.settingscreen.composable.settingScreenComposable

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.settingscreen.ui.theme.Rubik
import com.compose.settingscreen.viewModel.state.CardUiState

@SuppressLint("SuspiciousIndentation")
@Composable
fun SettingCard(
     card: CardUiState
//    icon : Painter,
//    settingName : String,
//    subTitle:String = "",
//    defaultBox: @Composable () -> Unit
){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp
    ){
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(shape = CircleShape),
                contentAlignment = Alignment.CenterStart
            ) {
                Image(
                    painter = painterResource(id = card.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(40.dp)
                )
            }

            Box(
                contentAlignment = Alignment.CenterStart
                , modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = card.settingName,
                    fontSize = 15.sp,
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

            }
            Text(
                text = card.subTitle,
                fontSize = 12.sp,
                fontFamily = Rubik,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 10.dp),
                color = Color.Gray
            )
            if (card.settingName == "Dark Mode"){
                card.defaultBox  = CustomSwitch()
            }
            else
            card.defaultBox = DefaultBox(iconSize = 25)

        }
}}
