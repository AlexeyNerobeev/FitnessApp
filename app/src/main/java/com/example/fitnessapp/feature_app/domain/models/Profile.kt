package com.example.fitnessapp.feature_app.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val id: Int = 0,
    val fio: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val birthday: String = "",
    val user_id: String = "",
    val gender: String = "",
    val phone: String = "",
    val target: String = "",
)
