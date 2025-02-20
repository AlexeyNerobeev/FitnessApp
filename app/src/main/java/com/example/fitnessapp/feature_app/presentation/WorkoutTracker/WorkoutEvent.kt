package com.example.fitnessapp.feature_app.presentation.WorkoutTracker

sealed class WorkoutEvent {
    data object IsCheckedAll: WorkoutEvent()
    data object IsCheckedUp: WorkoutEvent()
}