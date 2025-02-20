package com.example.fitnessapp.feature_app.domain.usecase

import com.example.fitnessapp.feature_app.domain.repository.AuthRepository

class AddTargetUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(target: String){
        authRepository.addTodayTarget(target)
    }
}