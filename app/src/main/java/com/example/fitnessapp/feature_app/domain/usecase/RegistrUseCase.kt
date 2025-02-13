package com.example.fitnessapp.feature_app.domain.usecase

import com.example.fitnessapp.feature_app.domain.repository.AuthRepository

class RegistrUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String, fio: String, number: String){
        authRepository.registration(email, password)
        authRepository.addFioNumber(fio, number)
    }
}