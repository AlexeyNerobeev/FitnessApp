package com.example.fitnessapp.feature_app.presentation.Registration

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegisterVM: ViewModel() {
    private val _state = mutableStateOf(RegistrState())
    val state: State<RegistrState> = _state

    fun onEvent(event: RegistrEvent){
        when(event){
            is RegistrEvent.EnteredFio ->{
                _state.value = state.value.copy(
                    fio = event.value
                )
            }
            is RegistrEvent.EnteredNumber ->{
                _state.value = state.value.copy(
                    phone = event.value
                )
            }
            is RegistrEvent.EnteredEmail ->{
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is RegistrEvent.EnteredPassword ->{
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            is RegistrEvent.ChangeErrorMessage ->{
                _state.value = state.value.copy(
                    errorMessage = event.value
                )
            }
            is RegistrEvent.IsChecked ->{
                _state.value = state.value.copy(
                    check = !state.value.check
                )
            }
            is RegistrEvent.VisualTransformation ->{
                _state.value = state.value.copy(
                    visual = !state.value.visual
                )
            }
            is RegistrEvent.EnteredGender ->{
                _state.value = state.value.copy(
                    gender = event.value
                )
            }
            is RegistrEvent.EnteredWeight ->{
                _state.value = state.value.copy(
                    weight = event.value
                )
            }
            is RegistrEvent.EnteredHeight ->{
                _state.value = state.value.copy(
                    height = event.value
                )
            }
            is RegistrEvent.IsComplete ->{
                _state.value = state.value.copy(
                    isComplete = true
                )
            }
            is RegistrEvent.EnteredBirthday ->{
                _state.value = state.value.copy(
                    birthday = event.value
                )
            }
            RegistrEvent.Registration ->{

            }
        }
    }
}