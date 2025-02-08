package com.example.fitnessapp.di

import com.example.fitnessapp.presentation.Login.LoginVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleVM = module {

    viewModel<LoginVM> {
        LoginVM(get())
    }
}