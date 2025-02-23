package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repositoryImplementation.TargetRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.TargetRepository
import com.example.fitnessapp.feature_app.domain.usecase.Targets.GetTodayTargetUseCase
import org.koin.dsl.module

val moduleTarget = module {
    single<TargetRepository> {
        TargetRepositoryImpl()
    }
    factory<GetTodayTargetUseCase> {
        GetTodayTargetUseCase(get())
    }
}