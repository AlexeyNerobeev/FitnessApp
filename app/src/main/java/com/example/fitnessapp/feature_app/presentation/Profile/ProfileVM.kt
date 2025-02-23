package com.example.fitnessapp.feature_app.presentation.Profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.models.Profile
import com.example.fitnessapp.feature_app.domain.usecase.Profile.GetProfileUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileVM(
    private val profileUseCase: GetProfileUseCase
): ViewModel() {
    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    fun onEvent(event: ProfileEvent){
        when(event){
            is ProfileEvent.ChangeCheck ->{
                _state.value = state.value.copy(
                    check = !state.value.check
                )
            }
            is ProfileEvent.GetProfile ->{
                viewModelScope.launch(Dispatchers.IO) {
                    try{
                        val profile: Profile = profileUseCase.invoke()
                        _state.value = state.value.copy(
                            name = profile.fio,
                            target = profile.target,
                            height = profile.height,
                            weight = profile.weight,
                            birthday = profile.birthday
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
            is ProfileEvent.GoToWorkoutTracker ->{
                _state.value = state.value.copy(
                    goToWorkout = true
                )
            }
            is ProfileEvent.ClearError ->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
        }
    }
}