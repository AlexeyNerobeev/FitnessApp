package com.example.fitnessapp.feature_app.domain.usecase.SharedPreferenses

import com.example.fitnessapp.feature_app.domain.repository.SharedPrefsRepository

class SavePrefsUseCase(
    private val sharedPrefsRepository: SharedPrefsRepository
){
    operator fun invoke(value: Int){
        sharedPrefsRepository.SavePreferences(value)
    }
}