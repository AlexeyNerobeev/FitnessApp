package com.example.fitnessapp.feature_app.presentation.WorkoutDetails1

data class WorkoutDetails1State (
    val name: String = "",
    val description: String = "",
    val complexity: String = "",
    val date: String = "",
    val congratulation: Boolean = false,
    val error: String = ""
)