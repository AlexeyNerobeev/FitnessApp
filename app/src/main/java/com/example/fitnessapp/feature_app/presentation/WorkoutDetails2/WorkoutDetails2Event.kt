package com.example.fitnessapp.feature_app.presentation.WorkoutDetails2

sealed class WorkoutDetails2Event {
    data object GetExerciseData: WorkoutDetails2Event()
    data object GetExerciseSteps: WorkoutDetails2Event()
    data object ClearError: WorkoutDetails2Event()
}