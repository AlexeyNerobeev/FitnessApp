package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repositoryImplementation.NotificationRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.NotificationRepository
import com.example.fitnessapp.feature_app.domain.usecase.GetNotificationsUseCase
import com.example.fitnessapp.feature_app.domain.usecase.NewNotificationUseCase
import org.koin.dsl.module

val moduleNotification = module{
    single<NotificationRepository> {
        NotificationRepositoryImpl()
    }
    factory<GetNotificationsUseCase> {
        GetNotificationsUseCase(get())
    }
    factory<NewNotificationUseCase> {
        NewNotificationUseCase(get())
    }
}