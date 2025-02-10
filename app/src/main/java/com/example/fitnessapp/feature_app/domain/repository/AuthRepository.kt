package com.example.fitnessapp.feature_app.domain.repository

import com.example.fitnessapp.feature_app.presentation.RegistartionPage2.RegistrEvent2

interface AuthRepository {
    suspend fun logIn(inputEmail: String, inputPassword: String)
    suspend fun registration(inputEmail: String, inputPassword: String)
    suspend fun addFioNumber(fio: String, number: String)
    suspend fun addProfile(gender: String, birthday: String, weight: Int, height: Int)
}