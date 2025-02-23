package com.example.fitnessapp.feature_app.domain.usecase.Workout

import com.example.fitnessapp.feature_app.domain.models.Workout
import com.example.fitnessapp.feature_app.domain.repository.WorkoutRepository

class GetWorkoutDataUseCase(
    private val workoutRepository: WorkoutRepository
) {
    suspend operator fun invoke(): Workout{
        return workoutRepository.getWorkoutData()
    }
}