package com.example.fitnessapp.feature_app.presentation.WorkoutDetails1

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.GetWorkoutDataUseCase
import com.example.fitnessapp.feature_app.domain.usecase.SaveCompleteWorkoutUseCase
import io.ktor.util.Digest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkoutDetails1VM(
    private val getWorkoutDataUseCase: GetWorkoutDataUseCase,
    private val saveCompleteWorkoutUseCase: SaveCompleteWorkoutUseCase
): ViewModel() {
    private val _state = mutableStateOf(WorkoutDetails1State())
    val state: State<WorkoutDetails1State> = _state

    fun onEvent(event: WorkoutDetails1Event) {
        when (event) {
            is WorkoutDetails1Event.GetWorkoutData -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        val workout = getWorkoutDataUseCase.invoke()
                        _state.value = state.value.copy(
                            name = workout.name,
                            complexity = workout.complexity,
                            description = workout.description,
                            date = workout.date
                        )
                    } catch(ex: Exception) {
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
            is WorkoutDetails1Event.SaveCompleteWorkout ->{
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        saveCompleteWorkoutUseCase.invoke(state.value.name, "Выполнено")
                        _state.value = state.value.copy(
                            congratulation = true
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
            is WorkoutDetails1Event.ClearError ->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
        }
    }
}