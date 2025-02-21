package com.example.fitnessapp.feature_app.presentation.SuccessRegistartion

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.GetNameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuccessRegistrationVM(
    private val getNameUseCase: GetNameUseCase
): ViewModel() {
    private val _state = mutableStateOf(SuccessRegistrationState())
    val state: State<SuccessRegistrationState> = _state

    fun onEvent(event: SuccessRegistrationEvent){
        when(event){
            SuccessRegistrationEvent.GetName ->{
                try {
                    viewModelScope.launch(Dispatchers.IO) {
                        _state.value = state.value.copy(
                            name = getNameUseCase.invoke()
                        )
                    }
                } catch (ex: Exception){
                    _state.value = state.value.copy(
                        exception = ex.message.toString()
                    )
                }
            }
            SuccessRegistrationEvent.ClearException -> {
                _state.value = state.value.copy(
                    exception = ""
                )
            }
        }
    }
}