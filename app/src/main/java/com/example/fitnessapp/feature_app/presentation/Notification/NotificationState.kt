package com.example.fitnessapp.feature_app.presentation.Notification

import com.example.fitnessapp.feature_app.domain.models.Notification

data class NotificationState(
    val items: Int = 0,
    val notifications: List<Notification> = listOf()
)