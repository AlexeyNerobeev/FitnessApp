package com.example.fitnessapp.feature_app.domain.repository

interface AuthRepository {
    suspend fun logIn(inputEmail: String, inputPassword: String)
    suspend fun registration()
}