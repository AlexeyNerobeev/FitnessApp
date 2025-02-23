package com.example.fitnessapp.feature_app.domain.usecase.Targets

import com.example.fitnessapp.feature_app.domain.repository.AuthRepository

class AddTodayTargetUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(water: Int, steps: Int){
        authRepository.addTodayTarget(water = water, steps = steps)
    }
}