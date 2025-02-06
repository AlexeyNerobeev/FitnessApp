package com.example.fitnessapp.presentation.Login

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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.presentation.WelcomeScreen.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import com.example.fitnessapp.presentation.WelcomeScreen.poppinsFont

@Preview
@Composable
fun PrevLogin(){
    val n = rememberNavController()
    val vm = LoginVM()
    LoginPage(n, vm)
}

@Composable
fun LoginPage(navController: NavController, vm: LoginVM = viewModel()) {

    val state = vm.state.value

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Привет,",
                color = Color.Black,
                fontWeight = FontWeight(400),
                fontFamily = montserratRegular,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 40.dp)
            )
            Text(text = "Добро пожаловать",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                fontFamily = montserratBold
           )

            Column(modifier = Modifier
                .padding(top = 30.dp)
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = state.email,
                    onValueChange = {
                        vm.onEvent(LoginEvent.EnterEmail(it))
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedTextColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedContainerColor = colorResource(R.color.tfColor)
                    ),
                    placeholder = {
                        Text(
                            text = "Почта",
                            color = colorResource(R.color.placeholderColor),
                            fontFamily = montserratRegular,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.email_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(vertical = 15.dp)
                                .padding(start = 15.dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(100.dp)
                )
                OutlinedTextField(
                    value = vm.password,
                    onValueChange = {
                        vm.password = it
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedTextColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedContainerColor = colorResource(R.color.tfColor)
                    ),
                    placeholder = {
                        Text(
                            text = "Пароль",
                            color = colorResource(R.color.placeholderColor),
                            fontFamily = montserratRegular,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.lock_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(vertical = 15.dp)
                                .padding(start = 15.dp)
                        )
                    },
                    visualTransformation =
                        if(vm.visual){
                            PasswordVisualTransformation()
                        } else{
                            VisualTransformation.None
                        },
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(100.dp),
                    trailingIcon = {
                        Icon(painter = painterResource(R.drawable.hide_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(vertical = 15.dp)
                                .padding(end = 15.dp)
                                .clickable {
                                    vm.visual = !vm.visual
                                }
                        )
                    }
                )
                Text(text = "Забыл пароль?",
                    color = colorResource(R.color.placeholderColor),
                    fontWeight = FontWeight(500),
                    fontSize = 12.sp,
                    fontFamily = montserratRegular,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .padding(top = 10.dp)
               )
            }
            Box(modifier = Modifier
                .fillMaxSize()){
                Column(modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .align(Alignment.BottomCenter),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(onClick = {

                    },
                        modifier = Modifier
                            .background(brush = Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.startGradient),
                                    colorResource(R.color.endGradient)
                                )
                            ),
                                shape = RoundedCornerShape(99.dp))
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.White
                        )) {
                        Row(){
                            Icon(painter = painterResource(R.drawable.login_icon),
                                contentDescription = null,
                                tint = Color.White)
                            Text(text = "Войти",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                fontFamily = montserratBold,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )
                        }
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
                                    .padding(15.dp)
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
                                    .padding(15.dp)
                                    .size(20.dp)
                            )
                        }
                    }
                    Row(modifier = Modifier
                        .padding(top = 30.dp)
                        .padding(bottom = 40.dp)) {
                        Text(text = "Нет аккаунта? ",
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = poppinsFont
                        )
                        Text(text = "Зарегистрироваться",
                            color = colorResource(R.color.clickableText),
                            fontFamily = poppinsFont,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(NavRoutes.RegisterPage.route)
                                }
                        )
                    }
                }
            }
        }
    }
}