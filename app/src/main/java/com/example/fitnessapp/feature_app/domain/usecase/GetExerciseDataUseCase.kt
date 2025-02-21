package com.example.fitnessapp.feature_app.domain.usecase

import com.example.fitnessapp.feature_app.domain.models.Exercise
import com.example.fitnessapp.feature_app.domain.repository.WorkoutRepository

class GetExerciseDataUseCase(
    private val workoutRepository: WorkoutRepository
) {
    suspend operator fun invoke(): Exercise{
        return workoutRepository.getExerciseData()
    }
}