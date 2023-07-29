package com.example.unscramble2.ui

import androidx.lifecycle.ViewModel
import com.example.unscramble2.UnscrambleUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UnscrambleViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(UnscrambleUiState())
    val uiState = _uiState.asStateFlow()

    fun updateWord(newWord: String) {
        _uiState.value = _uiState.value.copy(
            currentWord = newWord
        )
    }

}