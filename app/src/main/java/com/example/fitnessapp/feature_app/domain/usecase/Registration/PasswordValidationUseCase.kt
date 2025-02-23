package com.example.fitnessapp.feature_app.domain.usecase.Registration

class PasswordValidationUseCase {
    fun checkPassword(password: String): Boolean{
        return password.length >= 6
    }
}