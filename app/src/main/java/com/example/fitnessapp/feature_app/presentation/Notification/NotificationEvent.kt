package com.example.fitnessapp.feature_app.presentation.Notification

sealed class NotificationEvent {
    data object GetNotifications: NotificationEvent()
    data object ClearError: NotificationEvent()
}