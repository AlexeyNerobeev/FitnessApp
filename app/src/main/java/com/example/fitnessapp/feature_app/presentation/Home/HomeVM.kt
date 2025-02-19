package com.example.fitnessapp.feature_app.presentation.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.GetNameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeVM(
    private val getNameUseCase: GetNameUseCase
): ViewModel() {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    fun onEvent(event: HomeEvent){
        when(event){
            is HomeEvent.GetName ->{
                viewModelScope.launch(Dispatchers.IO) {
                    _state.value = state.value.copy(
                        name = getNameUseCase.invoke()
                    )
                }
            }
        }
    }
}