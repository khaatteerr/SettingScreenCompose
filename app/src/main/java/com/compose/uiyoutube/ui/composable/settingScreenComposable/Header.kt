package com.compose.uiyoutube.ui.composable.settingScreenComposable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.compose.uiyoutube.ui.theme.PrimaryTextColor
import com.compose.uiyoutube.ui.theme.Rubik
import com.compose.uiyoutube.ui.theme.SecondaryTextColor

@Composable
fun Header(title:String,subtitle:String,modifier: Modifier = Modifier){
    Column(
        modifier = modifier ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            color = Color.White,
            fontFamily = Rubik,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = subtitle,
            color = Color.White,
            fontFamily = Rubik,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SettingPreview() {
    Header("Ahmed","personal")
}