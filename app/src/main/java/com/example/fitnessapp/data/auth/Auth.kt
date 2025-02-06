package com.example.fitnessapp.data.auth

import com.example.fitnessapp.data.supabase.Connect.supabase
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class Auth {
    suspend fun auth(inputEmail: String, inputPassword: String){
        val user = supabase.auth.signInWith(Email){
            email = inputEmail
            password = inputPassword
        }
    }
}