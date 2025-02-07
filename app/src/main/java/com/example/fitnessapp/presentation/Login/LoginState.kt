package com.example.fitnessapp.presentation.Login

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

data class LoginState(
    val email: String = "",
    val password: String = "",
    val visual: Boolean = true
)