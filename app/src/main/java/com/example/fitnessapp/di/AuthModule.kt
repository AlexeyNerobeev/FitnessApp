package com.example.fitnessapp.di

import com.example.fitnessapp.data.repository.AuthRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.AuthRepository
import com.example.fitnessapp.feature_app.domain.usecase.AddTargetUseCase
import com.example.fitnessapp.feature_app.domain.usecase.GetNameUseCase
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
    factory<AddTargetUseCase>{
        AddTargetUseCase(get())
    }
    factory<GetNameUseCase>{
        GetNameUseCase(get())
    }
}