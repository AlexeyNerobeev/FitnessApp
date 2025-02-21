package com.example.fitnessapp.feature_app.presentation.RegistartionPage2

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.Registr2UseCase
import com.example.fitnessapp.feature_app.domain.usecase.RegistrUseCase
import com.example.fitnessapp.feature_app.presentation.Registration.RegistrEvent
import com.example.fitnessapp.presentation.Login.LoginEvent
import kotlinx.coroutines.launch

class RegistrVM2(
    private val registr2UseCase: Registr2UseCase
): ViewModel() {
    private val _state = mutableStateOf(RegistrState2())
    val state: State<RegistrState2> = _state

    fun onEvent(event: RegistrEvent2){
        when(event){
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
                    try {
                        if(state.value.gender.isNotEmpty() &&
                            state.value.birthday.isNotEmpty() &&
                            state.value.weight != 0 &&
                            state.value.height != 0){
                            registr2UseCase.invoke(state.value.gender, state.value.birthday,
                                state.value.weight, state.value.height)
                            _state.value = state.value.copy(
                                isComplete = true
                            )
                        } else{
                            _state.value = state.value.copy(
                                exception = "Не должно быть пустых полей!"
                            )
                        }
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            exception = ex.message.toString()
                        )
                    }
                }
            }
            RegistrEvent2.DropMenu -> {
                _state.value = state.value.copy(
                    expanded = !state.value.expanded
                )
            }
            is RegistrEvent2.SelectGender -> {
                _state.value = state.value.copy(
                    gender = event.value
                )
            }
            RegistrEvent2.ClearException -> {
                _state.value = state.value.copy(
                    exception = ""
                )
            }
        }
    }
}