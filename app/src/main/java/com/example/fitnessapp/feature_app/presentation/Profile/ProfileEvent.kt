package com.example.fitnessapp.feature_app.presentation.Profile

sealed class ProfileEvent {
    data object ChangeCheck: ProfileEvent()
}