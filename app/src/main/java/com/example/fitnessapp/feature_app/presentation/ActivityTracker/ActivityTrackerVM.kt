package com.example.fitnessapp.feature_app.presentation.ActivityTracker

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.models.Target
import com.example.fitnessapp.feature_app.domain.usecase.Targets.GetTodayTargetUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityTrackerVM(
    private val getTodayTargetUseCase: GetTodayTargetUseCase
): ViewModel() {
    private val _state = mutableStateOf(ActivityTrackerState())
    val state: State<ActivityTrackerState> = _state

    fun onEvent(event: ActivityTrackerEvent){
        when(event){
            is ActivityTrackerEvent.GetTodayTarget ->{
                viewModelScope.launch(Dispatchers.IO){
                    try {
                        val target: Target = getTodayTargetUseCase.invoke()
                        _state.value = state.value.copy(
                            water = target.water,
                            steps = target.steps
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
            is ActivityTrackerEvent.ClearError ->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
        }
    }
}