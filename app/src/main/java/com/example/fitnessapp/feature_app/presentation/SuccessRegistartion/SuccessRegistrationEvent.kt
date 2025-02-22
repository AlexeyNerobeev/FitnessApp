package com.example.fitnessapp.feature_app.presentation.SuccessRegistartion

sealed class SuccessRegistrationEvent {
    data object GetName: SuccessRegistrationEvent()
    data object ClearException: SuccessRegistrationEvent()
    data object NewNotification: SuccessRegistrationEvent()
}