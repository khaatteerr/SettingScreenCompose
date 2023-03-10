package com.compose.uiyoutube.ui.screens.music

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.compose.uiyoutube.ui.composable.BackPressHandler
import com.compose.uiyoutube.ui.theme.DeepBlue

@Composable
fun MusicScreen(
    viewModel: MusicViewModel = hiltViewModel(),
    navController: NavController
) {
    MusicContent()
    BackPressHandler(onBackPressed = {
        navController.popBackStack(
            "homeScreen",
            inclusive = false,
            saveState = false
        )
    })

}

@Composable
fun MusicContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue),

    ) {
    Column {

    }
    }
}