package com.example.fitnessapp.feature_app.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Notification(
    val id: Int = 0,
    val created_at: String = "",
    val user_id: String = "",
    val image: String = "",
    val text: String = ""
)
