package com.example.fitnessapp.feature_app.presentation.Profile

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.models.Profile
import com.example.fitnessapp.feature_app.domain.usecase.GetProfileUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.serializer

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
                        Log.e("supa", ex.message.toString())
                    }
                }
            }
        }
    }
}