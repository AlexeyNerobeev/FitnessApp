package com.example.fitnessapp.feature_app.domain.models

import android.icu.util.MeasureUnit.Complexity
import kotlinx.serialization.Serializable

@Serializable
data class Workout(
    val id: Int = 0,
    val name: String = "",
    val complexity: String = "",
    val user_id: String = "",
    val description: String = ""
)
