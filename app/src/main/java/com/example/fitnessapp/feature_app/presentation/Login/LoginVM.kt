package com.example.fitnessapp.presentation.Login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.fitnessapp.feature_app.domain.usecase.LoginUseCase
import io.github.jan.supabase.auth.Auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginVM(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun onEvent(event: LoginEvent){
        when (event){
            LoginEvent.SignIn -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        loginUseCase.invoke(state.value.email, state.value.password)
                        _state.value = state.value.copy(
                            isComplete = true
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            exception = ex.message.toString()
                        )
                        Log.e("supa", ex.message.toString())
                    }
                }
            }
            is LoginEvent.EnteredEmail -> {
               _state.value = state.value.copy(
                   email = event.value
               )
            }
            is LoginEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            is LoginEvent.VisualTransformation ->{
                _state.value = state.value.copy(
                    visual = !state.value.visual
                )
            }
            LoginEvent.ExceptionClear ->{
                _state.value = state.value.copy(
                    exception = ""
                )
            }
        }
    }
}