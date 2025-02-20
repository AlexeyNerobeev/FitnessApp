package com.example.fitnessapp.feature_app.presentation.Profile

sealed class ProfileEvent {
    data object ChangeCheck: ProfileEvent()
    data object GetProfile: ProfileEvent()
    data object GoToWorkoutTracker: ProfileEvent()
}