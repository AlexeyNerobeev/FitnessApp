package com.example.fitnessapp.feature_app.domain.repository

interface SharedPrefsRepository {
    fun SavePreferences(number: Int)

    fun GetPreferences() : Int

    fun ClearPreferences()
}