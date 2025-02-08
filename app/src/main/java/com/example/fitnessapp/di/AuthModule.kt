package com.example.fitnessapp.di

import com.example.fitnessapp.data.repository.AuthRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.AuthRepository
import com.example.fitnessapp.feature_app.domain.usecase.LoginUseCase
import org.koin.dsl.module

val moduleAuth = module{
    single<AuthRepository> {
        AuthRepositoryImpl()
    }
    factory<LoginUseCase>{
        LoginUseCase(get())
    }
}