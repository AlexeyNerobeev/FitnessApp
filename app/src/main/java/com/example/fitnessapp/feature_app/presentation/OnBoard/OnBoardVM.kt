package com.example.fitnessapp.presentation.OnBoard

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.OnNewIntentProvider
import androidx.lifecycle.ViewModel
import com.example.fitnessapp.feature_app.domain.usecase.SavePrefsUseCase
import com.example.fitnessapp.feature_app.presentation.OnBoard.OnBoardingEvent
import com.example.fitnessapp.feature_app.presentation.OnBoard.OnBoardingState

class OnBoardVM(
    private val sharedPrefsUseCase: SavePrefsUseCase
): ViewModel() {
    private val _state = mutableStateOf(OnBoardingState())
    val state: State<OnBoardingState> = _state

    fun onEvent(event: OnBoardingEvent){
        when(event){
            is OnBoardingEvent.ChangePref ->{
                sharedPrefsUseCase.invoke(event.value)
            }
            is OnBoardingEvent.Swipe ->{
                _state.value = state.value.copy(
                    swipe = event.value
                )
            }
        }
    }
}