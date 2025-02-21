package com.example.fitnessapp.feature_app.domain.usecase

import com.example.fitnessapp.feature_app.domain.repository.WorkoutRepository

class SaveCompleteWorkoutUseCase(
    private val workoutRepository: WorkoutRepository
){
    suspend operator fun invoke(name: String, status: String){
        workoutRepository.saveCompleteWorkout(name, status)
    }
}