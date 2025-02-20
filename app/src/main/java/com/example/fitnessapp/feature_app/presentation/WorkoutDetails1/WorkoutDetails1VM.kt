package com.example.fitnessapp.feature_app.presentation.WorkoutDetails1

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.GetWorkoutDataUseCase
import io.ktor.util.Digest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkoutDetails1VM(
    private val getWorkoutDataUseCase: GetWorkoutDataUseCase
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
                            description = workout.description
                        )
                    } catch(ex: Exception) {
                        Log.e("supa", ex.message.toString())
                    }
                }
            }
        }
    }
}