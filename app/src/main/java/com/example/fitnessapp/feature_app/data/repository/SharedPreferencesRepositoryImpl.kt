package com.example.fitnessapp.feature_app.data.repository

import android.content.Context
import com.example.fitnessapp.feature_app.domain.repository.SharedPrefsRepository

class SharedPreferencesRepositoryImpl(context: Context): SharedPrefsRepository {
    val sharedPreferences = context
        .getSharedPreferences("OnBPrefs", Context.MODE_PRIVATE)

    override fun SavePreferences(number: Int){
        sharedPreferences.edit().putInt("onBoard", number).apply()
    }

    override fun GetPreferences(): Int{
        return sharedPreferences.getInt("onBoard", 0)
    }

    override fun ClearPreferences(){
        sharedPreferences.edit().clear().apply()
    }
}