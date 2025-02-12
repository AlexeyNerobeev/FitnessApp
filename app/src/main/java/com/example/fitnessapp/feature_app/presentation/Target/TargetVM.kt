package com.example.fitnessapp.presentation.Target

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.AddTargetUseCase
import com.example.fitnessapp.feature_app.presentation.SuccessRegistartion.SuccessRegistrationEvent
import com.example.fitnessapp.feature_app.presentation.Target.TargetEvent
import com.example.fitnessapp.feature_app.presentation.Target.TargetState
import kotlinx.coroutines.launch

class TargetVM(
    private val addTargetUseCase: AddTargetUseCase
): ViewModel() {
    private val _state = mutableStateOf(TargetState())
    val state: State<TargetState> = _state

    fun onEvent(event: TargetEvent){
        when(event){
            TargetEvent.TapRight -> {
                if(state.value.cardNumber < 3){
                    _state.value = state.value.copy(
                        cardNumber = state.value.cardNumber + 1
                    )
                } else{
                    _state.value = state.value.copy(
                        cardNumber = 1
                    )
                }
            }
            TargetEvent.TapLeft -> {
                if(state.value.cardNumber > 1){
                    _state.value = state.value.copy(
                        cardNumber = state.value.cardNumber - 1
                    )
                } else{
                    _state.value = state.value.copy(
                        cardNumber = 3
                    )
                }
            }
            TargetEvent.AddTarget ->{
                viewModelScope.launch {
                    try {
                        when(state.value.cardNumber){
                            1 -> addTargetUseCase.invoke("Улучшить форму")
                            2 -> addTargetUseCase.invoke("Тонус")
                            3 -> addTargetUseCase.invoke("Похудеть")
                        }
                        _state.value = state.value.copy(
                            isComplete = true
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            exception = ex.message.toString()
                        )
                    }
                }
            }
            TargetEvent.ClearException ->{
                _state.value = state.value.copy(
                    exception = ""
                )
            }
        }
    }
}