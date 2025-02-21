package com.example.fitnessapp.feature_app.presentation.ActivityTracker

sealed class ActivityTrackerEvent {
    data object GetTodayTarget: ActivityTrackerEvent()
    data object ClearError: ActivityTrackerEvent()
}