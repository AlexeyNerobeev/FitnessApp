package com.example.fitnessapp.data.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Profile(
    val id: Int = 0,
    val fio: String = "",
    val target: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val birthday: String = "",
    val user_id: String = "",
    val gender: String = "",
    val phone: String = ""
)
