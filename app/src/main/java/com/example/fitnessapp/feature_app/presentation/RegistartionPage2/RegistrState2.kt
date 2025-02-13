package com.example.fitnessapp.feature_app.presentation.RegistartionPage2


data class RegistrState2(
    val gender: String = "",
    val birthday: String = "",
    val weight: Int = 0,
    val height: Int = 0,
    val isComplete: Boolean = false,
    val expanded: Boolean = false,
    val exception: String = ""
)
