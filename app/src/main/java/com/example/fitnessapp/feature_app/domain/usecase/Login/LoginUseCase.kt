package com.example.fitnessapp.feature_app.domain.usecase.Login

import com.example.fitnessapp.feature_app.domain.repository.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String){
        authRepository.logIn(email, password)
    }
}