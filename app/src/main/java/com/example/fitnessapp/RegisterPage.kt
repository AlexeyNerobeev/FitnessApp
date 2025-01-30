package com.example.fitnessapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

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
                OutlinedTextField(value = "",
                    onValueChange = {
                        vm.fio = it
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
                OutlinedTextField(value = "",
                    onValueChange = {
                        vm.phone = it
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
                OutlinedTextField(value = "",
                    onValueChange = {
                        vm.email = it
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
                OutlinedTextField(value = "",
                    onValueChange = {
                        vm.password = it
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
                    trailingIcon = {
                        Icon(painter = painterResource(R.drawable.hide_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 15.dp)
                                .padding(vertical = 15.dp))
                    }
                )
            }
        }
    }
}