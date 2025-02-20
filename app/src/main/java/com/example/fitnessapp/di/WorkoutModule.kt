package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repositoryImplementation.WorkoutRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.WorkoutRepository
import com.example.fitnessapp.feature_app.domain.usecase.GetWorkoutDataUseCase
import org.koin.dsl.module

val moduleWorkout = module {
    single<WorkoutRepository> {
        WorkoutRepositoryImpl()
    }
    factory<GetWorkoutDataUseCase> {
        GetWorkoutDataUseCase(get())
    }
}