package com.example.fitnessapp.feature_app.presentation.Profile

data class ProfileState(
    val check: Boolean = true,
    val name: String = "",
    val target: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val birthday: String = "",
    val goToWorkout: Boolean = false,
    val error: String = ""
)