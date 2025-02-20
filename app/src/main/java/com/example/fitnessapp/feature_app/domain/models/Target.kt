package com.example.fitnessapp.feature_app.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Target(
    val id: Int = 0,
    val water: Int = 0,
    val steps: Int = 0,
    val user_id: String = ""
)