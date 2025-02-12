package com.example.fitnessapp.feature_app.presentation.Target

import java.lang.Exception

data class TargetState(
    val cardNumber: Int = 1,
    val isComplete: Boolean = false,
    val exception: String = ""
)
