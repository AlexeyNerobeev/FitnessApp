package com.example.fitnessapp.feature_app.domain.usecase.Targets

import com.example.fitnessapp.feature_app.domain.models.Target
import com.example.fitnessapp.feature_app.domain.repository.TargetRepository

class GetTodayTargetUseCase(
    private val targetRepository: TargetRepository
) {
    suspend operator fun invoke(): Target{
        return targetRepository.getTodayTarget()
    }
}