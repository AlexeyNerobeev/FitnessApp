package com.example.fitnessapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    val registerVM = RegisterVM()
    val loginVM = LoginVM()
    NavHost(navController = navController, startDestination = NavRoutes.WelcomeScreen.route){
        composable(NavRoutes.WelcomeScreen.route){ WelcomeScreen(navController)}
        composable(NavRoutes.OnBoarding1.route){ OnBoarding1(navController)}
        composable(NavRoutes.OnBoarding2.route){ OnBoarding2(navController)}
        composable(NavRoutes.OnBoarding3.route){ OnBoarding3(navController)}
        composable(NavRoutes.OnBoarding4.route){ OnBoarding4(navController)}
        composable(NavRoutes.RegisterPage.route){ RegisterPage(navController, registerVM)}
        composable(NavRoutes.LoginPage.route){ LoginPage(navController, loginVM)}
        composable(NavRoutes.RegisterPage2.route){ RegisterPage2(navController, registerVM)}
        composable(NavRoutes.Target1.route){ Target1(navController)}
        composable(NavRoutes.SuccessRegistration.route){ SuccessRegistration(navController, registerVM)}
    }
}

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
}