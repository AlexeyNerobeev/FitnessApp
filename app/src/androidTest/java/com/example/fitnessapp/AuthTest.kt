package com.example.fitnessapp

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fitnessapp.data.repository.AuthRepositoryImpl
import com.example.fitnessapp.feature_app.domain.usecase.Registration.EmailValidationUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Login.LoginUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Registration.PasswordValidationUseCase
import com.example.fitnessapp.presentation.Home.HomeScreen
import com.example.fitnessapp.presentation.Login.LoginPage
import com.example.fitnessapp.presentation.Login.LoginVM
import io.ktor.http.renderSetCookieHeader
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthTest {
    private val emailValidationUseCase = EmailValidationUseCase()
    private val passwordValidationUseCase = PasswordValidationUseCase()
    private val emailValidation = "qwerty"
    private val passwordValidation = "pass"
    private val emailAlert = "qwerty@gmail.com"
    private val passwordAlert = "password"
    private val correctEmail = "qwerty@gmail.com"
    private val correctPassword = "pass"
    private val incorrectEmail = "qwerty"
    private val incorrectPassword = "pass"

    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun emailValidationTest(){
        assert(emailValidationUseCase.checkEmail(emailValidation))
    }

    @Test
    fun passwordValidationTest(){
        assert(passwordValidationUseCase.checkPassword(passwordValidation))
    }

    @Test
    fun alertDialogIncorrectEmail(): Unit = with(rule){
        setContent {
            LoginPage(rememberNavController())
        }
        onNodeWithText("Почта").performTextInput(emailAlert)
        onNodeWithText("Пароль").performTextInput(correctPassword)
        onNodeWithText("Войти").performClick()
        onNodeWithText("Некорректная почта").assertIsDisplayed()
    }

    @Test
    fun alertDialogIncorrectPassword(): Unit = with(rule){
        setContent {
            LoginPage(rememberNavController())
        }
        onNodeWithText("Почта").performTextInput(correctEmail)
        onNodeWithText("Пароль").performTextInput(passwordAlert)
        onNodeWithText("Войти").performClick()
        onNodeWithText("Пароль должен содержать не менее 6 символов").assertIsDisplayed()
    }

    @Test
    fun successfulAuth(): Unit = with(rule){
        setContent {
            LoginPage(rememberNavController())
        }
        onNodeWithText("Почта").performTextInput(correctEmail)
        onNodeWithText("Пароль").performTextInput(correctPassword)
        onNodeWithText("Войти").performClick()
        setContent {
            HomeScreen(rememberNavController())
        }
        onNodeWithText("Добро пожаловать,").assertIsDisplayed()
    }
}