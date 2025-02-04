package com.example.fitnessapp.presentation.Registration.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegisterVM: ViewModel() {
    var fio by mutableStateOf("")
    var phone by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var check by mutableStateOf(false)
    var visual by mutableStateOf(true)

    var gender by mutableStateOf("")
    var birthday by mutableStateOf("")
    var weight by mutableIntStateOf(0)
    var height by mutableIntStateOf(0)
}