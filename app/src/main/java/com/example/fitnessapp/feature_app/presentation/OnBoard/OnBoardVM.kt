package com.example.fitnessapp.presentation.OnBoard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OnBoardVM: ViewModel() {
    var swipe by mutableStateOf(false)
}