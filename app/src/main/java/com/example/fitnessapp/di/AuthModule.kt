package com.example.fitnessapp.di

import com.example.fitnessapp.data.repository.AuthRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.AuthRepository
import com.example.fitnessapp.feature_app.domain.usecase.LoginUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Registr2UseCase
import com.example.fitnessapp.feature_app.domain.usecase.RegistrUseCase
import org.koin.dsl.module

val moduleAuth = module{
    single<AuthRepository> {
        AuthRepositoryImpl()
    }
    factory<LoginUseCase>{
        LoginUseCase(get())
    }
    factory<RegistrUseCase> {
        RegistrUseCase(get())
    }
    factory<Registr2UseCase> {
        Registr2UseCase(get())
    }
}