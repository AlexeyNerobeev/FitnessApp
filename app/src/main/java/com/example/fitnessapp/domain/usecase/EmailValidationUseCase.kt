package com.example.fitnessapp.domain.usecase

import android.util.Patterns

class EmailValidationUseCase {
    fun CheckEmail(email: String): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}