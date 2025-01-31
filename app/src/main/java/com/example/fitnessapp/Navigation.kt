package com.example.fitnessapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    val registerVM = RegisterVM()
    NavHost(navController = navController, startDestination = NavRoutes.WelcomeScreen.route){
        composable(NavRoutes.WelcomeScreen.route){ WelcomeScreen(navController)}
        composable(NavRoutes.OnBoarding1.route){ OnBoarding1()}
        composable(NavRoutes.RegisterPage.route){ RegisterPage(navController, registerVM)}
    }
}

sealed class NavRoutes(val route: String){
    object WelcomeScreen: NavRoutes("WelcomeScreen")
    object OnBoarding1: NavRoutes("OnBoarding1")
    object RegisterPage: NavRoutes("RegisterPage")
}