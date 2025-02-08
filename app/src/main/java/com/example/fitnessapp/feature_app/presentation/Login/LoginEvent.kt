package com.example.fitnessapp.presentation.Login

sealed class LoginEvent {

    data object SignIn : LoginEvent()
    data class EnteredEmail(val value: String): LoginEvent()
    data class EnteredPassword(val value: String): LoginEvent()
    data class VisualTransformation(val value: Boolean): LoginEvent()
}