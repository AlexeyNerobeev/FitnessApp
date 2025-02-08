package com.example.fitnessapp.feature_app.domain.usecase

import android.util.Patterns

class EmailValidationUseCase {
    fun CheckEmail(email: String): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}