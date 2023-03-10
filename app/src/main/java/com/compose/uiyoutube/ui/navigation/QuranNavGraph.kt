package com.compose.uiyoutube.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.compose.uiyoutube.ui.screens.home.HomeScreen
import com.compose.uiyoutube.ui.screens.music.MusicScreen
import com.compose.uiyoutube.ui.screens.search.SearchScreen
import com.compose.uiyoutube.ui.screens.settingscreen.SettingsScreen
import com.compose.uiyoutube.ui.screens.sleep.SleepScreen

@Composable
fun QuranNavGraph(navController: NavHostController){
    NavHost(navController = navController , startDestination = "homeScreen"){
        composable("homeScreen"){ HomeScreen(navController = navController) }
        composable("searchScreen"){ SearchScreen(navController= navController) }
        composable("musicScreen"){ MusicScreen(navController= navController) }
        composable("settingScreen"){ SettingsScreen(navController = navController) }
    }
}