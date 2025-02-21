package com.example.fitnessapp

sealed class NavRoutes(val route: String){
    data object WelcomeScreen: NavRoutes("WelcomeScreen")
    data object OnBoarding1: NavRoutes("OnBoarding1")
    data object OnBoarding2: NavRoutes("OnBoarding2")
    data object OnBoarding3: NavRoutes("OnBoarding3")
    data object OnBoarding4: NavRoutes("OnBoarding4")
    data object RegisterPage: NavRoutes("RegisterPage")
    data object LoginPage: NavRoutes("LoginPage")
    data object RegisterPage2: NavRoutes("RegisterPage2")
    data object Target: NavRoutes("Target")
    data object SuccessRegistration: NavRoutes("SuccessRegistration")
    data object Home: NavRoutes("Home")
    data object Notifications: NavRoutes("Notifications")
    data object ActivityTracker: NavRoutes("ActivityTracker")
    data object Profile: NavRoutes("Profile")
    data object WorkoutTracker: NavRoutes("WorkoutTracker")
    data object WorkoutSchedule: NavRoutes("WorkoutSchedule")
    data object WorkoutDetails1: NavRoutes("WorkoutDetails1")
    data object Congratulation: NavRoutes("Congratulation")
}