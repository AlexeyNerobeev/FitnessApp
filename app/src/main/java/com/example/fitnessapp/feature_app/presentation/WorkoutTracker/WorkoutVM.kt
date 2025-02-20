package com.example.fitnessapp.feature_app.presentation.WorkoutTracker

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WorkoutVM: ViewModel() {
    private val _state = mutableStateOf(WorkoutTrackerState())
    val state: State<WorkoutTrackerState> = _state

    fun onEvent(event: WorkoutEvent){
        when(event){
            is WorkoutEvent.IsCheckedAll ->{
                _state.value = state.value.copy(
                    checkAll = !state.value.checkAll
                )
            }
            is WorkoutEvent.IsCheckedUp ->{
                _state.value = state.value.copy(
                    checkUp = !state.value.checkUp
                )
            }
        }
    }
}