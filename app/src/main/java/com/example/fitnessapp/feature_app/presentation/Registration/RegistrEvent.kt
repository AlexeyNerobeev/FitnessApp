package com.example.fitnessapp.feature_app.presentation.Registration

import android.media.metrics.Event

sealed class RegistrEvent{
    data class EnteredFio(val value: String): RegistrEvent()
    data class EnteredNumber(val value: String): RegistrEvent()
    data class EnteredEmail(val value: String): RegistrEvent()
    data class EnteredPassword(val value: String): RegistrEvent()
    data object IsChecked: RegistrEvent()
    data object Registration: RegistrEvent()
    data class ChangeErrorMessage(val value: String): RegistrEvent()
    data object VisualTransformation: RegistrEvent()
    data class EnteredGender(val value: String): RegistrEvent()
    data class EnteredBirthday(val value: String): RegistrEvent()
    data class EnteredWeight(val value: Int): RegistrEvent()
    data class EnteredHeight(val value: Int): RegistrEvent()
    data class IsComplete(val value: Boolean): RegistrEvent()
}