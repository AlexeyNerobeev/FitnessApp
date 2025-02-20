package com.example.fitnessapp.feature_app.domain.repository

import com.example.fitnessapp.feature_app.domain.models.Workout

interface WorkoutRepository {
    suspend fun getWorkoutData(): Workout
}