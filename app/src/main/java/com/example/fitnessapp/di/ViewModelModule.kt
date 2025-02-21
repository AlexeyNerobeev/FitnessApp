package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.domain.models.Target
import com.example.fitnessapp.feature_app.presentation.ActivityTracker.ActivityTrackerVM
import com.example.fitnessapp.feature_app.presentation.Home.HomeVM
import com.example.fitnessapp.feature_app.presentation.Notification.NotificationVM
import com.example.fitnessapp.feature_app.presentation.Profile.ProfileVM
import com.example.fitnessapp.feature_app.presentation.RegistartionPage2.RegistrVM2
import com.example.fitnessapp.feature_app.presentation.Registration.RegisterVM
import com.example.fitnessapp.feature_app.presentation.SuccessRegistartion.SuccessRegistrationVM
import com.example.fitnessapp.feature_app.presentation.WelcomeScreen.WelcomeVM
import com.example.fitnessapp.feature_app.presentation.WorkoutDetails1.WorkoutDetails1VM
import com.example.fitnessapp.feature_app.presentation.WorkoutTracker.WorkoutVM
import com.example.fitnessapp.presentation.Login.LoginVM
import com.example.fitnessapp.presentation.OnBoard.OnBoardVM
import com.example.fitnessapp.presentation.Target.TargetVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleVM = module {

    viewModel<LoginVM> {
        LoginVM(get())
    }
    viewModel<RegisterVM>{
        RegisterVM(get(), get())
    }
    viewModel<RegistrVM2>{
        RegistrVM2(get())
    }
    viewModel<OnBoardVM>{
        OnBoardVM(get())
    }
    viewModel<WelcomeVM>{
        WelcomeVM(get())
    }
    viewModel<TargetVM>{
        TargetVM(get())
    }
    viewModel<SuccessRegistrationVM>{
        SuccessRegistrationVM(get())
    }
    viewModel<ProfileVM>{
        ProfileVM(get())
    }
    viewModel<TargetVM>{
        TargetVM(get())
    }
    viewModel<ActivityTrackerVM>{
        ActivityTrackerVM(get())
    }
    viewModel<NotificationVM>{
        NotificationVM(get())
    }
    viewModel<HomeVM>{
        HomeVM(get())
    }
    viewModel<WorkoutVM>{
        WorkoutVM()
    }
    viewModel<WorkoutDetails1VM>{
        WorkoutDetails1VM(get(), get())
    }
}