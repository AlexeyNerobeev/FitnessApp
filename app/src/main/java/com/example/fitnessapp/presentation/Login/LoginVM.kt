package com.example.fitnessapp.presentation.Login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginVM: ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var visual by mutableStateOf(true)
}