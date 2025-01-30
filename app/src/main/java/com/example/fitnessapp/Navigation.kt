package com.example.fitnessapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.WelcomeScreen.route){
        composable(NavRoutes.WelcomeScreen.route){ WelcomeScreen(navController)}
        composable(NavRoutes.OnBoarding1.route){ OnBoarding1()}
    }
}

sealed class NavRoutes(val route: String){
    object WelcomeScreen: NavRoutes("WelcomeScreen")
    object OnBoarding1: NavRoutes("OnBoarding1")
}