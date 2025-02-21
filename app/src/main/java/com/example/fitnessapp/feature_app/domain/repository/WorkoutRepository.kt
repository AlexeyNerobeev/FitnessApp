package com.example.fitnessapp.feature_app.domain.repository

import com.example.fitnessapp.feature_app.domain.models.Exercise
import com.example.fitnessapp.feature_app.domain.models.Workout

interface WorkoutRepository {
    suspend fun getWorkoutData(): Workout
    suspend fun saveCompleteWorkout(name: String, status: String)
    suspend fun getExerciseData(): Exercise
}