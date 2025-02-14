package com.example.fitnessapp.feature_app.presentation.Notification

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NotificationVM: ViewModel() {
    private val _state = mutableStateOf(NotificationState())
    val state: State<NotificationState> = _state
}