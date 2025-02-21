package com.example.fitnessapp.feature_app.presentation.WorkoutDetails1

sealed class WorkoutDetails1Event {
    data object GetWorkoutData: WorkoutDetails1Event()
    data object SaveCompleteWorkout: WorkoutDetails1Event()
    data object ClearError: WorkoutDetails1Event()
}