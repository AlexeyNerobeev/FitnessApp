package com.example.fitnessapp.feature_app.domain.usecase.SharedPreferenses

import com.example.fitnessapp.feature_app.domain.repository.SharedPrefsRepository

class GetPrefsUseCase(
    private val sharedPrefsRepository: SharedPrefsRepository
) {
    operator fun invoke(): Int{
        return sharedPrefsRepository.GetPreferences()
    }
}