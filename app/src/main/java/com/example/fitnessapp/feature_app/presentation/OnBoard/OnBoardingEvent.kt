package com.example.fitnessapp.feature_app.presentation.OnBoard

sealed class OnBoardingEvent {
    data class Swipe(val value: Boolean): OnBoardingEvent()
    data class ChangePref(val value: Int): OnBoardingEvent()
}