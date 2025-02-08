package com.example.fitnessapp.presentation.Registration.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.data.registration.Registration
import com.example.fitnessapp.feature_app.domain.usecase.EmailValidationUseCase
import com.example.fitnessapp.presentation.IncorrectEmailSnackBar.IncorrectEmailSnackBar
import com.example.fitnessapp.feature_app.presentation.Registration.RegisterVM
import com.example.fitnessapp.feature_app.presentation.Registration.RegistrEvent
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import com.example.fitnessapp.presentation.WelcomeScreen.poppinsFont
import kotlinx.coroutines.launch

val montserratBold = FontFamily(
    Font(
        resId = R.font.montserratbold
    )
)

@Preview
@Composable
fun PrevRegister(){
    val n = rememberNavController()
    val vm = RegisterVM()
    RegisterPage(n, vm)
}

@Composable
fun RegisterPage(navController: NavController, vm: RegisterVM) {
    val state = vm.state.value
    LaunchedEffect(key1 = !state.isComplete) {
        if(state.isComplete){
            navController.navigate(NavRoutes.RegisterPage2.route)
        }
    }
    Scaffold(modifier = Modifier
        .fillMaxSize()) {innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Text(text = "Привет,",
                color = Color.Black,
                fontFamily = montserratRegular,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 40.dp))
            Text(text = "Создай аккаунт",
                color = Color.Black,
                fontFamily = montserratBold,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 5.dp))
            Column(modifier = Modifier
                .padding(top = 30.dp)
                .padding(horizontal = 30.dp)
                .fillMaxWidth()) {
                OutlinedTextField(value = state.fio,
                    onValueChange = {
                        vm.onEvent(RegistrEvent.EnteredFio(it))
                    },
                    shape = RoundedCornerShape(100.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedTextColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedContainerColor = colorResource(R.color.tfColor)
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = {
                        Text(text = "ФИО",
                            color = colorResource(R.color.placeholderColor),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    },
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.profile_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(start = 15.dp)
                                .padding(vertical = 15.dp))
                    }
                )
                OutlinedTextField(value = state.phone,
                    onValueChange = {
                        vm.onEvent(RegistrEvent.EnteredNumber(it))
                    },
                    shape = RoundedCornerShape(100.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedTextColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedContainerColor = colorResource(R.color.tfColor)
                    ),
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth(),
                    placeholder = {
                        Text(text = "Номер телефона",
                            color = colorResource(R.color.placeholderColor),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    },
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.phone_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(start = 15.dp)
                                .padding(vertical = 15.dp))
                    }
                )
                OutlinedTextField(value = state.email,
                    onValueChange = {
                        vm.onEvent(RegistrEvent.EnteredEmail(it))
                    },
                    shape = RoundedCornerShape(100.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedTextColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedContainerColor = colorResource(R.color.tfColor)
                    ),
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth(),
                    placeholder = {
                        Text(text = "Почта",
                            color = colorResource(R.color.placeholderColor),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    },
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.email_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(start = 15.dp)
                                .padding(vertical = 15.dp))
                    }
                )
                OutlinedTextField(value = state.password,
                    onValueChange = {
                        vm.onEvent(RegistrEvent.EnteredPassword(it))
                    },
                    shape = RoundedCornerShape(100.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedTextColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedContainerColor = colorResource(R.color.tfColor)
                    ),
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth(),
                    placeholder = {
                        Text(text = "Пароль",
                            color = colorResource(R.color.placeholderColor),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    },
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.lock_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(start = 15.dp)
                                .padding(vertical = 15.dp))
                    },
                    visualTransformation = if(state.visual) PasswordVisualTransformation()
                    else VisualTransformation.None,
                    trailingIcon = {
                        Icon(painter = painterResource(R.drawable.hide_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(end = 15.dp)
                                .padding(vertical = 15.dp)
                                .clickable {
                                    vm.onEvent(RegistrEvent.VisualTransformation)
                                })
                    }
                )
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)){
                    Checkbox(checked = state.check,
                        onCheckedChange = {
                            vm.onEvent(RegistrEvent.IsChecked)
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Blue,
                            uncheckedColor = colorResource(R.color.placeholderColor)
                        ),
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Text(text = "Продолжая, вы принимаете нашу Политику конфиденциальности и Условия использования.",
                        color = colorResource(R.color.placeholderColor),
                        fontFamily = montserratRegular,
                        fontWeight = FontWeight(400),
                        fontSize = 10.sp,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
                Box(modifier = Modifier
                    .fillMaxSize()){
                    Column(modifier = Modifier
                        .align(Alignment.BottomCenter),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        val coroutine = rememberCoroutineScope()
                        val emailCheck = EmailValidationUseCase()
                        Button(onClick = {
                            if(state.check){
                                if(emailCheck.CheckEmail(state.email)){
                                    coroutine.launch {
                                        val registration = Registration()
                                        registration.registration(
                                            state.email,
                                            state.password,
                                            navController
                                        )
                                    }
                                } else{
                                    vm.onEvent(RegistrEvent.ChangeErrorMessage("Некорректная почта"))
                                }
                            } else{
                                vm.onEvent(RegistrEvent.ChangeErrorMessage("Примите Политику конфиденциальности"))
                            }
                        },
                            shape = RoundedCornerShape(100.dp),
                            modifier = Modifier
                                .background(brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        colorResource(R.color.startGradient),
                                        colorResource(R.color.endGradient)
                                    )
                                ),
                                    RoundedCornerShape(100.dp)),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White
                            )) {
                            Text(text = "Зарегистрироваться",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontFamily = montserratBold,
                                fontWeight = FontWeight(700)
                            )
                        }
                        Image(
                            painter = painterResource(R.drawable.or),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 20.dp))
                        Row(modifier = Modifier
                            .padding(top = 20.dp)) {
                            IconButton(onClick = {

                            },
                                modifier = Modifier
                                    .border(
                                        width = 0.8f.dp, color = colorResource(R.color.borderColor),
                                        shape = RoundedCornerShape(14.dp)
                                    )
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.google_icon),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                            IconButton(onClick = {

                            },
                                modifier = Modifier
                                    .padding(start = 30.dp)
                                    .border(
                                        width = 0.8f.dp, color = colorResource(R.color.borderColor),
                                        shape = RoundedCornerShape(14.dp)
                                    )
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.yandex_icon),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                        }
                        Row(modifier = Modifier
                            .padding(top = 30.dp)
                            .padding(bottom = 40.dp)) {
                            Text(text = "Имеете уже аккаунт? ",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = poppinsFont
                           )
                            Text(text = "Войти",
                                color = colorResource(R.color.clickableText),
                                fontFamily = poppinsFont,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(NavRoutes.LoginPage.route)
                                    }
                            )
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            if(state.error.isNotEmpty()){
                IncorrectEmailSnackBar(state.error)
            }
        }
    }
}