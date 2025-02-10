package com.example.fitnessapp.feature_app.presentation.RegistartionPage2

import com.example.fitnessapp.feature_app.presentation.Registration.RegistrEvent

data class RegistrState2(
    val gender: String = "",
    val birthday: String = "",
    val weight: Int = 0,
    val height: Int = 0,
    val isComplete: Boolean = false
)
