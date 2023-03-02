package com.compose.settingscreen.viewModel

import androidx.lifecycle.ViewModel
import com.compose.settingscreen.R
import com.compose.settingscreen.viewModel.state.CardUiState
import com.compose.settingscreen.viewModel.state.SettingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class SettingViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(SettingUiState())
    val state = _state.asStateFlow()

    init {
        getCards()
    }


    private fun getCards() {
        _state.update {
            it.copy(
                cards = listOf(
                    CardUiState(
                        R.drawable.notification, "Notifications", "", null
                    ), CardUiState(
                        R.drawable.language_translator, "Language", "English", null
                    ), CardUiState(
                        R.drawable.password, "Password", "", null
                    ), CardUiState(
                        R.drawable.dark_mode_9bvcfarp8pyf, "Dark Mode", "", null
                    ), CardUiState(
                        R.drawable.faq, "FAQ", "", null
                    )
                )
            )
        }
    }
}