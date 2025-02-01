package com.example.fitnessapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun PrevRegisterPage2(){
    val n = rememberNavController()
    val vm = RegisterVM()
    RegisterPage2(n, vm)
}

@Composable
fun RegisterPage2(navController: NavController, vm: RegisterVM) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            item {


                Image(
                    painter = painterResource(R.drawable.reg_p2_art),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .padding(start = 67.dp)
                        .padding(end = 87.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Давайте создадим\n" +
                                "ваш профиль",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = montserratBold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Это поможет нам узнать о вас больше!",
                        color = Color.Black,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                        fontFamily = montserratRegular,
                        modifier = Modifier
                            .padding(top = 10.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .padding(start = 30.dp)
                        .padding(end = 50.dp)
                ) {
                    OutlinedTextField(
                        value = vm.gender,
                        onValueChange = {
                            vm.gender = it
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = colorResource(R.color.tfColor),
                            focusedBorderColor = colorResource(R.color.tfColor),
                            unfocusedContainerColor = colorResource(R.color.tfColor),
                            focusedContainerColor = colorResource(R.color.tfColor),
                            unfocusedTextColor = Color.Black,
                            focusedTextColor = Color.Black
                        ),
                        placeholder = {
                            Text(
                                text = "Ваш пол",
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
                                painter = painterResource(R.drawable.gender_icon),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .padding(start = 15.dp)
                                    .padding(vertical = 15.dp)
                            )
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.dropdown),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .padding(end = 15.dp)
                                    .padding(vertical = 15.dp)
                            )
                        },
                        shape = RoundedCornerShape(100.dp),
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = vm.birthday,
                        onValueChange = {
                            vm.birthday = it
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = colorResource(R.color.tfColor),
                            focusedBorderColor = colorResource(R.color.tfColor),
                            unfocusedContainerColor = colorResource(R.color.tfColor),
                            focusedContainerColor = colorResource(R.color.tfColor),
                            unfocusedTextColor = Color.Black,
                            focusedTextColor = Color.Black
                        ),
                        placeholder = {
                            Text(
                                text = "Дата рождения",
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
                                painter = painterResource(R.drawable.calendar),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .padding(start = 15.dp)
                                    .padding(vertical = 15.dp)
                            )
                        },
                        shape = RoundedCornerShape(100.dp),
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = "",
                            onValueChange = {
                                vm.weight = it.toInt()
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = colorResource(R.color.tfColor),
                                focusedBorderColor = colorResource(R.color.tfColor),
                                unfocusedContainerColor = colorResource(R.color.tfColor),
                                focusedContainerColor = colorResource(R.color.tfColor),
                                unfocusedTextColor = Color.Black,
                                focusedTextColor = Color.Black
                            ),
                            placeholder = {
                                Text(
                                    text = "Ваш вес",
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
                                    painter = painterResource(R.drawable.weight_icon),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .padding(start = 15.dp)
                                        .padding(vertical = 15.dp)
                                )
                            },
                            shape = RoundedCornerShape(100.dp),
                            modifier = Modifier
                                .weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .padding(start = 15.dp)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            colorResource(R.color.startGradient),
                                            colorResource(R.color.endGradient)
                                        )
                                    ),
                                    shape = CircleShape
                                )
                                .size(48.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "КГ",
                                color = Color.White,
                                fontWeight = FontWeight(500),
                                fontSize = 12.sp,
                                fontFamily = montserratRegular
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = "",
                            onValueChange = {
                                vm.height = it.toInt()
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = colorResource(R.color.tfColor),
                                focusedBorderColor = colorResource(R.color.tfColor),
                                unfocusedContainerColor = colorResource(R.color.tfColor),
                                focusedContainerColor = colorResource(R.color.tfColor),
                                unfocusedTextColor = Color.Black,
                                focusedTextColor = Color.Black
                            ),
                            placeholder = {
                                Text(
                                    text = "Ваш рост",
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
                                    painter = painterResource(R.drawable.height_icon),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .padding(start = 15.dp)
                                        .padding(vertical = 15.dp)
                                )
                            },
                            shape = RoundedCornerShape(100.dp),
                            modifier = Modifier
                                .weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .padding(start = 15.dp)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            colorResource(R.color.startGradient),
                                            colorResource(R.color.endGradient)
                                        )
                                    ),
                                    shape = CircleShape
                                )
                                .size(48.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "CM",
                                color = Color.White,
                                fontWeight = FontWeight(500),
                                fontSize = 12.sp,
                                fontFamily = montserratRegular
                            )
                        }
                    }
                }
                Button(
                    onClick = {
                        navController.navigate(NavRoutes.Target1.route)
                    },
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .padding(horizontal = 40.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.startGradient),
                                    colorResource(R.color.endGradient)
                                )
                            ), shape = RoundedCornerShape(99.dp)
                        )
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Transparent
                    )
                ) {
                    Row() {
                        Text(
                            text = "Далее",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                            fontFamily = montserratBold
                        )
                        Icon(
                            painter = painterResource(R.drawable.arrow),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                    }
                }
            }
        }
    }
}