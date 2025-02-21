package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repositoryImplementation.WorkoutRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.WorkoutRepository
import com.example.fitnessapp.feature_app.domain.usecase.GetExerciseDataUseCase
import com.example.fitnessapp.feature_app.domain.usecase.GetWorkoutDataUseCase
import com.example.fitnessapp.feature_app.domain.usecase.SaveCompleteWorkoutUseCase
import org.koin.core.scope.get
import org.koin.dsl.module

val moduleWorkout = module {
    single<WorkoutRepository> {
        WorkoutRepositoryImpl()
    }
    factory<GetWorkoutDataUseCase> {
        GetWorkoutDataUseCase(get())
    }
    factory<SaveCompleteWorkoutUseCase>{
        SaveCompleteWorkoutUseCase(get())
    }
    factory<GetExerciseDataUseCase> {
        GetExerciseDataUseCase(get())
    }
}