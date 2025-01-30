package com.example.fitnessapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegisterVM: ViewModel() {
    var fio by mutableStateOf("")
    var phone by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
}