package com.example.fitnessapp.data.registration

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.fitnessapp.data.supabase.Connect.supabase
import com.example.fitnessapp.presentation.IncorrectEmailSnackBar.IncorrectEmailSnackBar
import com.example.fitnessapp.presentation.Registration.models.RegisterVM
import com.example.fitnessapp.presentation.WelcomeScreen.NavRoutes
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Registration() {
    suspend fun registration(inputEmail: String, inputPassword: String,
                             navController: NavController){
        withContext(Dispatchers.Main){
            try{
                val user = supabase.auth.signUpWith(Email){
                    email = inputEmail
                    password = inputPassword
                }
                navController.navigate(NavRoutes.RegisterPage2.route)
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }
}