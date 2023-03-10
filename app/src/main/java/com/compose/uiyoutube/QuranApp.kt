package com.compose.uiyoutube

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.compose.uiyoutube.ui.navigation.BottomMenu
import com.compose.uiyoutube.ui.navigation.QuranNavGraph
import com.compose.uiyoutube.ui.screens.home.BottomMenuContent
import com.compose.uiyoutube.ui.theme.DeepBlue

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun QuranApp(

) {

    val navController = rememberNavController()
    val list = listOf(
        BottomMenuContent("Home", "homeScreen", R.drawable.ic_home ),
        BottomMenuContent("Search", "searchScreen", R.drawable.ic_search),
        BottomMenuContent("Music", "musicScreen", R.drawable.ic_music),
        BottomMenuContent("Profile", "settingScreen", R.drawable.ic_profile)
    )

    Scaffold( backgroundColor = DeepBlue,
        bottomBar = {
            BottomMenu(
                items =list ,
                navController = navController
            ) {
                navController.navigate(it.route)

            }

        }
    ) {
        QuranNavGraph(navController = navController)
    }

}