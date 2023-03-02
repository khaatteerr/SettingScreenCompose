package com.compose.settingscreen.viewModel.state

data class SettingUiState(val cards :List<CardUiState> = emptyList())

data class CardUiState(
    val icon : Int,
    val settingName : String,
    val subTitle:String = "",
    var defaultBox:  Unit ?
)
