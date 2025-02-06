package com.example.fitnessapp.domain.sharedPrefs

interface SharedPrefsInterface {
    fun SavePreferences(number: Int)

    fun GetPreferences() : Int

    fun ClearPreferences()
}