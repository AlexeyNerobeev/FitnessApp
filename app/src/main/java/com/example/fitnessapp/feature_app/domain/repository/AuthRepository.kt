package com.example.fitnessapp.feature_app.domain.repository

interface AuthRepository {
    suspend fun logIn(inputEmail: String, inputPassword: String)
    suspend fun registration(inputEmail: String, inputPassword: String)
    suspend fun addFioNumber(fio: String, number: String)
    suspend fun addProfile(gender: String, birthday: String, weight: Int, height: Int)
    suspend fun addTodayTarget(target: String)
    suspend fun getName(): String
    suspend fun addTodayTarget(water: Int, steps: Int)
}