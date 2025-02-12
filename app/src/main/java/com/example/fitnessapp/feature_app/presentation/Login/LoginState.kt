package com.example.fitnessapp.presentation.Login

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.lang.Exception

data class LoginState(
    val email: String = "",
    val password: String = "",
    val visual: Boolean = true,
    val isComplete: Boolean = false,
    val exception: String = ""
)