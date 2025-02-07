package com.example.fitnessapp.data.auth

import android.util.Log
import androidx.navigation.NavController
import com.example.fitnessapp.data.supabase.Connect.supabase
import com.example.fitnessapp.presentation.WelcomeScreen.NavRoutes
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Auth {
    suspend fun auth(inputEmail: String, inputPassword: String,
                     navController: NavController){
            try{
                val user = supabase.auth.signInWith(Email){
                    email = inputEmail
                    password = inputPassword
                }
                navController.navigate(NavRoutes.Home.route)
            } catch(ex: Exception){
                Log.e("supa", ex.message.toString())
            }
    }
}