package com.example.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.feature_app.presentation.ActivityTracker.ActivityTrackerScreen
import com.example.fitnessapp.feature_app.presentation.Notification.NotificationScreen
import com.example.fitnessapp.feature_app.presentation.Profile.ProfileScreen
import com.example.fitnessapp.presentation.Home.HomeScreen
import com.example.fitnessapp.presentation.Login.LoginPage
import com.example.fitnessapp.presentation.OnBoard.OnBoarding1
import com.example.fitnessapp.presentation.OnBoard.OnBoarding2
import com.example.fitnessapp.presentation.OnBoard.OnBoarding3
import com.example.fitnessapp.presentation.OnBoard.OnBoarding4
import com.example.fitnessapp.presentation.Registration.screens.RegisterPage
import com.example.fitnessapp.presentation.Registration.screens.RegisterPage2
import com.example.fitnessapp.presentation.Registration.screens.SuccessRegistration
import com.example.fitnessapp.presentation.Target.TargetScreen
import com.example.fitnessapp.presentation.WelcomeScreen.WelcomeScreen
import com.example.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = NavRoutes.WelcomeScreen.route){
                    composable(NavRoutes.WelcomeScreen.route){ WelcomeScreen(navController) }
                    composable(NavRoutes.OnBoarding1.route){ OnBoarding1(navController) }
                    composable(NavRoutes.OnBoarding2.route){ OnBoarding2(navController) }
                    composable(NavRoutes.OnBoarding3.route){ OnBoarding3(navController) }
                    composable(NavRoutes.OnBoarding4.route){ OnBoarding4(navController) }
                    composable(NavRoutes.RegisterPage.route){ RegisterPage(navController) }
                    composable(NavRoutes.LoginPage.route){ LoginPage(navController) }
                    composable(NavRoutes.RegisterPage2.route){ RegisterPage2(navController) }
                    composable(NavRoutes.Target.route){ TargetScreen(navController) }
                    composable(NavRoutes.SuccessRegistration.route){ SuccessRegistration(navController) }
                    composable(NavRoutes.Home.route){ HomeScreen(navController) }
                    composable(NavRoutes.Notifications.route){ NotificationScreen(navController)}
                    composable(NavRoutes.ActivityTracker.route){ ActivityTrackerScreen(navController)}
                    composable(NavRoutes.Profile.route){ ProfileScreen(navController)}
                }
            }
        }
    }
}