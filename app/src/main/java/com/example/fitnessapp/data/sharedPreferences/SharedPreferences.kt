package com.example.fitnessapp.data.sharedPreferences

import android.content.Context
import com.example.fitnessapp.domain.sharedPrefs.SharedPrefsInterface

class SharedPreferences(context: Context): SharedPrefsInterface {
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