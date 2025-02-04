package com.example.fitnessapp.presentation.Target

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.fitnessapp.R
import com.example.fitnessapp.presentation.MainActivity.navigation.NavRoutes
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular

@Preview
@Composable
fun PrevTarget1(){
    val n = rememberNavController()
    Target1(n)
}

@Composable
fun Target1(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(Modifier.padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Column(modifier = Modifier
                .padding(top = 40.dp)
                .padding(start = 90.dp)
                .padding(end = 78.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Какова ваша цель?",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = montserratBold,
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Center
                )
                Text(text = "Это поможет нам подобрать для вас лучшую программу.",
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = montserratRegular,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 5.dp)
               )
            }
            Box(modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth()) {
                Box(modifier = Modifier
                    .offset(x = (-175).dp)
                    .padding(top = 90.dp)
                    .background(brush = Brush.horizontalGradient(
                        colors = listOf(
                            colorResource(R.color.startGradient),
                            colorResource(R.color.endGradient)
                        )
                    ), shape = RoundedCornerShape(22.dp))
                    .size(205.dp, 358.dp)
                )
                Box(modifier = Modifier
                    .width(275.dp)
                    .background(brush = Brush.horizontalGradient(
                        colors = listOf(
                            colorResource(R.color.startGr),
                            colorResource(R.color.endGr)
                        )
                    ), shape = RoundedCornerShape(22.dp)
                    )
                    .align(Alignment.Center)){
                    Column(modifier = Modifier
                        .padding(top = 35.dp)
                        .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painter = painterResource(R.drawable.card1_art),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(horizontal = 46.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop)
                        Text(text = "Улучшить форму",
                            color = Color.White,
                            fontWeight = FontWeight(600),
                            fontSize = 14.sp,
                            fontFamily = montserratRegular,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 25.dp)
                       )
                        Image(painter = painterResource(R.drawable.line),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 3.dp))
                        Text(text = "У меня мало жира в организме, и мне нужно нарастить больше мышечной массы.",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = montserratRegular,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(horizontal = 30.dp)
                                .padding(top = 20.dp)
                                .padding(bottom = 30.dp)
                                .fillMaxWidth()
                       )
                    }
                }
                Box(modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 175.dp)
                    .padding(top = 90.dp)
                    .background(brush = Brush.horizontalGradient(
                        colors = listOf(
                            colorResource(R.color.endGradient),
                            colorResource(R.color.startGradient)
                        )
                    ), shape = RoundedCornerShape(22.dp))
                    .size(205.dp, 358.dp)
                )
            }
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter){
                Button(onClick = {
                    navController.navigate(NavRoutes.SuccessRegistration.route)
                },
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .padding(bottom = 40.dp)
                        .background(brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.startGradient),
                                colorResource(R.color.endGradient)
                            )
                        ),
                            shape = RoundedCornerShape(99.dp))
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Transparent
                    )) {
                    Text(text = "Подтвердить",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = montserratBold
                   )
                }
            }
        }
    }
}