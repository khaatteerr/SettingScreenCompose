package com.compose.uiyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.compose.uiyoutube.ui.screens.home.HomeScreen
import com.compose.uiyoutube.ui.screens.settingscreen.SettingsScreen
import com.compose.uiyoutube.ui.theme.UIYoutubeTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIYoutubeTheme {
                QuranApp()
            }
        }
    }
}

