package com.example.fitnessapp.feature_app.domain.usecase.Registration

import android.util.Patterns

class EmailValidationUseCase {
    fun checkEmail(email: String): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}