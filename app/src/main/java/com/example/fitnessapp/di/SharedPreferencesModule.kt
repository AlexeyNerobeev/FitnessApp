package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repositoryImplementation.SharedPreferencesRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.SharedPrefsRepository
import com.example.fitnessapp.feature_app.domain.usecase.SharedPreferenses.GetPrefsUseCase
import com.example.fitnessapp.feature_app.domain.usecase.SharedPreferenses.SavePrefsUseCase
import org.koin.dsl.module

val moduleSharedPreferences = module{
    single<SharedPrefsRepository> {
        SharedPreferencesRepositoryImpl(get())
    }
    factory<GetPrefsUseCase> {
        GetPrefsUseCase(get())
    }
    factory<SavePrefsUseCase>{
        SavePrefsUseCase(get())
    }
}