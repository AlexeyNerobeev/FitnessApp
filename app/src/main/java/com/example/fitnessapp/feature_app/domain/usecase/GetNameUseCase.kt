package com.example.fitnessapp.feature_app.domain.usecase

import com.example.fitnessapp.feature_app.domain.repository.AuthRepository

class GetNameUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): String{
        return authRepository.getName()
    }
}