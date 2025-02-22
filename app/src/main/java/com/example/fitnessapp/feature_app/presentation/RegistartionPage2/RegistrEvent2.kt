package com.example.fitnessapp.feature_app.presentation.RegistartionPage2

import com.example.fitnessapp.feature_app.presentation.Registration.RegistrEvent

sealed class RegistrEvent2 {
    data class EnteredBirthday(val value: String): RegistrEvent2()
    data class EnteredWeight(val value: String): RegistrEvent2()
    data class EnteredHeight(val value: String): RegistrEvent2()
    data object DropMenu: RegistrEvent2()
    data class SelectGender(val value: String): RegistrEvent2()
    data object Registration: RegistrEvent2()
    data object ClearException: RegistrEvent2()
}