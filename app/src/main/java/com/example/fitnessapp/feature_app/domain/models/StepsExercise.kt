package com.example.fitnessapp.feature_app.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class StepsExercise(
    val id : Int = 0,
    val title: String = "",
    val description: String = "",
    val exercise_id: Int = 0
)
