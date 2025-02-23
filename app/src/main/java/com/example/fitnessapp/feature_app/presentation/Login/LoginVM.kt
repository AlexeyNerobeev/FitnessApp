package com.example.fitnessapp.presentation.Login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.Login.LoginUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Registration.EmailValidationUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Registration.PasswordValidationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginVM(
    private val loginUseCase: LoginUseCase,
    private val emailValidationUseCase: EmailValidationUseCase,
    private val passwordValidationUseCase: PasswordValidationUseCase
): ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun onEvent(event: LoginEvent){
        when (event){
            LoginEvent.SignIn -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        if(emailValidationUseCase.checkEmail(state.value.email)){
                            if(passwordValidationUseCase.checkPassword(state.value.password)){
                                loginUseCase.invoke(state.value.email, state.value.password)
                                _state.value = state.value.copy(
                                    isComplete = true
                                )
                            } else{
                                _state.value = state.value.copy(
                                    exception = "Пароль должен содержать не менее 6 символов"
                                )
                            }
                        } else{
                            _state.value = state.value.copy(
                                exception = "Некорректная почта"
                            )
                        }
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