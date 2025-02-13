package com.example.fitnessapp.feature_app.domain.usecase

import com.example.fitnessapp.feature_app.domain.repository.AuthRepository

class Registr2UseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(gender: String, birthday: String, weight: Int,
                                height: Int){
        authRepository.addProfile(gender, birthday, weight, height)
    }
}