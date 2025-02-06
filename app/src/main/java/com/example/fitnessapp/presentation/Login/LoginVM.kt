package com.example.fitnessapp.presentation.Login

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginVM: ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var visual by mutableStateOf(true)

    fun onEvent(event: LoginEvent){
        when (event){
            is LoginEvent.EnterEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
        }
    }
}