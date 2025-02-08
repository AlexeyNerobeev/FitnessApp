package com.example.fitnessapp.feature_app.domain.sharedPrefs

interface SharedPrefsInterface {
    fun SavePreferences(number: Int)

    fun GetPreferences() : Int

    fun ClearPreferences()
}