package com.example.fitnessapp.feature_app.presentation.RegistartionPage2

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.Registr2UseCase
import com.example.fitnessapp.feature_app.domain.usecase.RegistrUseCase
import com.example.fitnessapp.feature_app.presentation.Registration.RegistrEvent
import kotlinx.coroutines.launch

class RegistrVM2(
    private val registr2UseCase: Registr2UseCase
): ViewModel() {
    private val _state = mutableStateOf(RegistrState2())
    val state: State<RegistrState2> = _state

    fun onEvent(event: RegistrEvent2){
        when(event){
            is RegistrEvent2.EnteredGender ->{
                _state.value = state.value.copy(
                    gender = event.value
                )
            }
            is RegistrEvent2.EnteredBirthday ->{
                _state.value = state.value.copy(
                    birthday = event.value
                )
            }
            is RegistrEvent2.EnteredWeight ->{
                _state.value = state.value.copy(
                    weight = event.value
                )
            }
            is RegistrEvent2.EnteredHeight ->{
                _state.value = state.value.copy(
                    height = event.value
                )
            }
            RegistrEvent2.Registration ->{
                viewModelScope.launch {
                    registr2UseCase.invoke(state.value.gender, state.value.birthday,
                        state.value.weight, state.value.height)
                }
                _state.value = state.value.copy(
                    isComplete = true
                )
            }
        }
    }
}