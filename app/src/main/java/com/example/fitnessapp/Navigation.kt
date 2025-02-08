package com.example.fitnessapp

sealed class NavRoutes(val route: String){
    object WelcomeScreen: NavRoutes("WelcomeScreen")
    object OnBoarding1: NavRoutes("OnBoarding1")
    object OnBoarding2: NavRoutes("OnBoarding2")
    object OnBoarding3: NavRoutes("OnBoarding3")
    object OnBoarding4: NavRoutes("OnBoarding4")
    object RegisterPage: NavRoutes("RegisterPage")
    object LoginPage: NavRoutes("LoginPage")
    object RegisterPage2: NavRoutes("RegisterPage2")
    object Target1: NavRoutes("Target1")
    object SuccessRegistration: NavRoutes("SuccessRegistration")
    object Home: NavRoutes("Home")
}