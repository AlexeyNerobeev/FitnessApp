package com.example.fitnessapp.feature_app.presentation.Target

sealed class TargetEvent {
    data object TapRight: TargetEvent()
    data object TapLeft: TargetEvent()
    data object AddTarget: TargetEvent()
}