package com.example.fitnessapp.feature_app.presentation.WelcomeScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.fitnessapp.feature_app.domain.usecase.SharedPreferenses.GetPrefsUseCase

class WelcomeVM(
    private val getPrefsUseCase: GetPrefsUseCase
): ViewModel() {
    private val _state = mutableStateOf(WelcomeState())
    val state: State<WelcomeState> = _state

    fun onEvent(event: WelcomeEvent){
        when(event){
            is WelcomeEvent.GetNumber ->{
                _state.value = state.value.copy(
                    number = getPrefsUseCase.invoke()
                )
            }
        }
    }
}