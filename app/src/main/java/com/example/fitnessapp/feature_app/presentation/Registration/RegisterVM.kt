package com.example.fitnessapp.feature_app.presentation.Registration

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.AddTodayTargetUseCase
import com.example.fitnessapp.feature_app.domain.usecase.RegistrUseCase
import com.example.fitnessapp.feature_app.presentation.RegistartionPage2.RegistrEvent2
import kotlinx.coroutines.launch

class RegisterVM(
    private val registrUseCase: RegistrUseCase,
    private val addTodayTargetUseCase: AddTodayTargetUseCase
): ViewModel() {
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
            is RegistrEvent.IsComplete ->{
                _state.value = state.value.copy(
                    isComplete = true
                )
            }
            RegistrEvent.Registration ->{
                viewModelScope.launch {
                    try {
                        if(state.value.email.isNotEmpty() &&
                            state.value.password.isNotEmpty() &&
                            state.value.fio.isNotEmpty() &&
                            state.value.phone.isNotEmpty()){
                            registrUseCase.invoke(state.value.email, state.value.password,
                                state.value.fio, state.value.phone)
                            addTodayTargetUseCase.invoke(8, 2400)
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
            RegistrEvent.ClearException -> {
                _state.value = state.value.copy(
                    exception = ""
                )
            }
        }
    }
}