package com.example.fitnessapp.feature_app.presentation.WelcomeScreen

sealed class WelcomeEvent {
    data object GetNumber: WelcomeEvent()
}