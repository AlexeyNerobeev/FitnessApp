package com.example.fitnessapp.presentation.Login

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.github.jan.supabase.auth.Auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginVM(): ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var visual by mutableStateOf(true)


    fun onEvent(event: LoginEvent){
        when (event){
            LoginEvent.SignIn -> {
                viewModelScope.launch(Dispatchers.IO) {
                    //TODO
                    val auth = com.example.fitnessapp.data.auth.Auth()
                    //auth.auth(email, password, navController)
                }
            }
        }
    }
}