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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.RegistartionPage2.RegistrEvent2
import com.example.fitnessapp.feature_app.presentation.RegistartionPage2.RegistrVM2
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevRegisterPage2(){
    val n = rememberNavController()
    RegisterPage2(n)
}

@Composable
fun RegisterPage2(navController: NavController, vm: RegistrVM2 = koinViewModel()) {
    val state = vm.state.value
    LaunchedEffect(key1 = !state.isComplete) {
        if(state.isComplete){
            navController.navigate(NavRoutes.Target.route)
        }
    }
    if(state.exception.isNotEmpty()){
        ErrorAlertDialog(state.exception) {
            vm.onEvent(RegistrEvent2.ClearException)
        }
    }
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
                        value = state.gender,
                        onValueChange = {

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
                                    .clickable {
                                        vm.onEvent(RegistrEvent2.DropMenu)
                                    }
                            )
                            DropdownMenu(expanded = state.expanded,
                                onDismissRequest = {
                                    vm.onEvent(RegistrEvent2.DropMenu)
                                },
                                modifier = Modifier
                                    .background(Color.White)
                                    .border(1.dp, Color.LightGray)) {
                                Text("Мужской",
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .clickable {
                                            vm.onEvent(RegistrEvent2.SelectGender("Мужской"))
                                            vm.onEvent(RegistrEvent2.DropMenu)
                                        })
                                Text("Женский",
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .clickable {
                                            vm.onEvent(RegistrEvent2.SelectGender("Женский"))
                                            vm.onEvent(RegistrEvent2.DropMenu)
                                        })
                            }
                        },
                        shape = RoundedCornerShape(100.dp),
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = state.birthday,
                        onValueChange = {
                            vm.onEvent(RegistrEvent2.EnteredBirthday(it))
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
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
                            value = if(state.weight == 0){
                                ""
                            } else{
                                state.weight.toString()
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            onValueChange = {
                                vm.onEvent(RegistrEvent2.EnteredWeight(it.toInt()))
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
                            value = if(state.height == 0){
                                ""
                            } else{
                                state.height.toString()
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            onValueChange = {
                                vm.onEvent(RegistrEvent2.EnteredHeight(it.toInt()))
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
                        vm.onEvent(RegistrEvent2.Registration)
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
                    Row{
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