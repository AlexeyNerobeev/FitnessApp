package com.example.fitnessapp.feature_app.domain.usecase

import com.example.fitnessapp.feature_app.domain.models.Notification
import com.example.fitnessapp.feature_app.domain.repository.NotificationRepository

class GetNotificationsUseCase(
    private val notificationRepository: NotificationRepository
) {
    suspend operator fun invoke(): List<Notification>{
        return notificationRepository.getNotifications()
    }
}