package com.example.fitnessapp.presentation.MainActivity

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.presentation.Registration.screens.SuccessRegistration
import com.example.fitnessapp.presentation.Target.Target1
import com.example.fitnessapp.presentation.Login.LoginVM
import com.example.fitnessapp.presentation.Login.LoginPage
import com.example.fitnessapp.presentation.OnBoard.OnBoardVM
import com.example.fitnessapp.presentation.OnBoard.OnBoarding1
import com.example.fitnessapp.presentation.OnBoard.OnBoarding2
import com.example.fitnessapp.presentation.OnBoard.OnBoarding3
import com.example.fitnessapp.presentation.OnBoard.OnBoarding4
import com.example.fitnessapp.presentation.Registration.models.RegisterVM
import com.example.fitnessapp.presentation.Registration.screens.RegisterPage
import com.example.fitnessapp.presentation.Registration.screens.RegisterPage2
import com.example.fitnessapp.presentation.WelcomeScreen.WelcomeScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    val registerVM = RegisterVM()
    val loginVM = LoginVM()
    val onBoardVM = OnBoardVM()
    NavHost(navController = navController, startDestination = NavRoutes.WelcomeScreen.route){
        composable(NavRoutes.WelcomeScreen.route){ WelcomeScreen(navController) }
        composable(NavRoutes.OnBoarding1.route){ OnBoarding1(navController, onBoardVM) }
        composable(NavRoutes.OnBoarding2.route){ OnBoarding2(navController, onBoardVM) }
        composable(NavRoutes.OnBoarding3.route){ OnBoarding3(navController, onBoardVM) }
        composable(NavRoutes.OnBoarding4.route){ OnBoarding4(navController, onBoardVM) }
        composable(NavRoutes.RegisterPage.route){ RegisterPage(navController, registerVM) }
        composable(NavRoutes.LoginPage.route){ LoginPage(navController, loginVM) }
        composable(NavRoutes.RegisterPage2.route){ RegisterPage2(navController, registerVM) }
        composable(NavRoutes.Target1.route){ Target1(navController) }
        composable(NavRoutes.SuccessRegistration.route){ SuccessRegistration(navController, registerVM) }
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