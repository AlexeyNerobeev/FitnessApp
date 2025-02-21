package com.example.fitnessapp.feature_app.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class CompleteWorkouts(
    val id: Int = 0,
    val name: String = "",
    val status: String = "",
    val user_id: String = ""
)
