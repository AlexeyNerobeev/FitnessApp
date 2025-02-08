package com.example.fitnessapp.feature_app.presentation.Registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class RegistrState(
    val fio: String = "",
    val phone: String = "",
    val email: String = "",
    val password: String = "",
    val check: Boolean = false,
    val visual: Boolean = true,
    val error: String = "",
    val isError: Boolean = false,
    val gender: String = "",
    val birthday: String = "",
    val weight: Int = 0,
    val height: Int = 0,
    val isComplete: Boolean = false,
    val errorMessage: String = ""
)
