package com.example.fitnessapp.feature_app.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Exercise (
    val id: Int = 0,
    val name: String = "",
    val complexity: String = "",
    val description: String = "",
    val approaches: Int = 0
)