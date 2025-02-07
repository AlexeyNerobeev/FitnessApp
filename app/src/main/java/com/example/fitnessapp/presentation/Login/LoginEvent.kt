package com.example.fitnessapp.presentation.Login

sealed class LoginEvent {

    data object SignIn : LoginEvent()
}