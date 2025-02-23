package com.example.fitnessapp.di

import com.example.fitnessapp.data.repository.AuthRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.AuthRepository
import com.example.fitnessapp.feature_app.domain.usecase.Targets.AddTargetUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Targets.AddTodayTargetUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Profile.GetNameUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Login.LoginUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Registration.Registr2UseCase
import com.example.fitnessapp.feature_app.domain.usecase.Registration.RegistrUseCase
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
    factory<AddTodayTargetUseCase>{
        AddTodayTargetUseCase(get())
    }
}