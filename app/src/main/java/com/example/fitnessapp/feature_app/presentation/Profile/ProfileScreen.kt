package com.example.fitnessapp.feature_app.presentation.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.common.TopAppBar
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import com.example.fitnessapp.presentation.WelcomeScreen.poppinsFont

@Preview
@Composable
fun PrevProfileScreen() {
    ProfileScreen(rememberNavController())
}

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
            ) {
                TopAppBar(navController, "Профиль", Color.Black)
                Column(
                    modifier = Modifier
                        .padding(top = 35.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.profile_icon),
                            contentDescription = null
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 15.dp)
                        ) {
                            Text(
                                text = "Олег Сергеев",
                                color = Color.Black,
                                fontFamily = montserratBold,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500)
                            )
                            Text(
                                text = "Программа «Похудей»",
                                color = colorResource(R.color.onBoardingText),
                                fontWeight = FontWeight(400),
                                fontFamily = montserratRegular,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .padding(start = 9.dp)
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            colorResource(R.color.startGradient),
                                            colorResource(R.color.endGradient)
                                        )
                                    ), shape = RoundedCornerShape(99.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Изменить",
                                color = Color.White,
                                fontWeight = FontWeight(500),
                                fontFamily = montserratRegular,
                                fontSize = 12.sp
                            )
                        }
                    }
                    Row(modifier = Modifier
                        .padding(15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Box(modifier = Modifier
                            .size(95.dp, 65.dp)
                            .background(Color.White,
                                RoundedCornerShape(16.dp))) {
                            Column(modifier = Modifier
                                .padding(vertical = 11.dp)
                                .padding(horizontal = 33.dp)
                                .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(text = "180",
                                    style = TextStyle(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGradient),
                                                colorResource(R.color.endGradient)
                                            )
                                        )
                                    ),
                                    fontFamily = poppinsFont,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500)
                                )
                                Text(text = "Рост",
                                    style = TextStyle(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGradient),
                                                colorResource(R.color.endGradient)
                                            )
                                        )
                                    ),
                                    fontFamily = poppinsFont,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400))
                            }
                        }
                        Box(modifier = Modifier
                            .size(95.dp, 65.dp)
                            .background(Color.White,
                                RoundedCornerShape(16.dp))) {
                            Column(modifier = Modifier
                                .padding(vertical = 11.dp)
                                .padding(horizontal = 33.dp)
                                .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(text = "65",
                                    style = TextStyle(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGradient),
                                                colorResource(R.color.endGradient)
                                            )
                                        )
                                    ),
                                    fontFamily = poppinsFont,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500)
                                )
                                Text(text = "Вес",
                                    style = TextStyle(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGradient),
                                                colorResource(R.color.endGradient)
                                            )
                                        )
                                    ),
                                    fontFamily = poppinsFont,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400))
                            }
                        }
                    }
                }
            }
        }
    }
}