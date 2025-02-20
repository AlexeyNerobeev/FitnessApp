package com.example.fitnessapp.feature_app.domain.repository

import com.example.fitnessapp.feature_app.domain.models.Notification

interface NotificationRepository {
    suspend fun getNotifications(): List<Notification>
}