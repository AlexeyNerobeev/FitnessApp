package com.example.fitnessapp.feature_app.domain.usecase.Notification

import com.example.fitnessapp.feature_app.domain.repository.NotificationRepository

class NewNotificationUseCase(
    private val notificationRepository: NotificationRepository
) {
    suspend operator fun invoke(){
        notificationRepository.newNotification()
    }
}