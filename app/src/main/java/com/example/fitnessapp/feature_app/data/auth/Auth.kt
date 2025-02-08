package com.example.fitnessapp.data.auth

import android.util.Log
import com.example.fitnessapp.data.supabase.Connect.supabase
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class Auth {
    suspend fun auth(inputEmail: String, inputPassword: String){
            try{
                val user = supabase.auth.signInWith(Email){
                    email = inputEmail
                    password = inputPassword
                }
            } catch(ex: Exception){
                Log.e("supa", ex.message.toString())
            }
    }
}