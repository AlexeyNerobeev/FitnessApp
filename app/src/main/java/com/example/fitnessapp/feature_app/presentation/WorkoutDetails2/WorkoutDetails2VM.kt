package com.example.fitnessapp.feature_app.presentation.WorkoutDetails2

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.GetExerciseDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkoutDetails2VM(
    private val getExerciseDataUseCase: GetExerciseDataUseCase
): ViewModel() {
    private val _state = mutableStateOf(WorkoutDetails2State())
    val state: State<WorkoutDetails2State> = _state

    fun onEvent(event: WorkoutDetails2Event){
        when(event){
            is WorkoutDetails2Event.GetExerciseData ->{
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        val exercise = getExerciseDataUseCase.invoke()
                        _state.value = state.value.copy(
                            name = exercise.name,
                            complexity = exercise.complexity,
                            description = exercise.description,
                            approaches = exercise.approaches
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
            is WorkoutDetails2Event.GetExerciseSteps ->{
                viewModelScope.launch(Dispatchers.IO) {
                    try {

                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
            is WorkoutDetails2Event.ClearError ->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
        }
    }
}