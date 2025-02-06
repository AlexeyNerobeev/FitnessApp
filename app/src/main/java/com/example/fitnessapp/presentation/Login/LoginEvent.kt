package com.example.fitnessapp.presentation.Login

sealed class LoginEvent {

    data class EnterEmail(val value: String) : LoginEvent()
}