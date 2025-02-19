package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repository.TargetRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.TargetRepository
import com.example.fitnessapp.feature_app.domain.usecase.GetTodayTargetUseCase
import org.koin.dsl.module

val moduleTarget = module {
    single<TargetRepository> {
        TargetRepositoryImpl()
    }
    factory<GetTodayTargetUseCase> {
        GetTodayTargetUseCase(get())
    }
}