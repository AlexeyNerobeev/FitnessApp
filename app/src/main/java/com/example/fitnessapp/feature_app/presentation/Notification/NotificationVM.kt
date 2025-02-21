package com.example.fitnessapp.feature_app.presentation.Notification

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.models.Notification
import com.example.fitnessapp.feature_app.domain.usecase.GetNotificationsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotificationVM(
    private val getNotificationsUseCase: GetNotificationsUseCase
): ViewModel() {
    private val _state = mutableStateOf(NotificationState())
    val state: State<NotificationState> = _state

    fun onEvent(event: NotificationEvent){
        when(event){
            is NotificationEvent.GetNotifications ->{
                viewModelScope.launch(Dispatchers.IO) {
                    try{
                        val notification: List<Notification> = getNotificationsUseCase.invoke()
                        _state.value = state.value.copy(
                            notifications = notification
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
            is NotificationEvent.ClearError ->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
        }
    }
}