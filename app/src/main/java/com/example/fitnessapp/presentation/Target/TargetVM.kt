package com.example.fitnessapp.presentation.Target

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TargetVM: ViewModel() {
    var card_number by mutableIntStateOf(1)
}