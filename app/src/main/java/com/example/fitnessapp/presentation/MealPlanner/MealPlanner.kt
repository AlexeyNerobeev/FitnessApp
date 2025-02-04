package com.example.fitnessapp.presentation.MealPlanner

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import com.example.fitnessapp.presentation.WelcomeScreen.poppinsFont

@Preview
@Composable
fun PrevMealPlanner(){
    val n = rememberNavController()
    MealPlanner(n)
}

@Composable
fun MealPlanner(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(innerPadding)) {
            Row(modifier = Modifier
                .padding(top = 40.dp)
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(onClick = {
                    navController.popBackStack()
                },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = colorResource(R.color.tfColor),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .background(colorResource(R.color.tfColor),
                            RoundedCornerShape(8.dp))
                        .size(32.dp)) {
                    Icon(painter = painterResource(R.drawable.arrow_back),
                        contentDescription = null,
                        tint = Color.Unspecified)
                }
                Text(text = "Планировщик питания",
                    color = Color.Black,
                    fontFamily = montserratBold,
                    fontWeight = FontWeight(700),
                    fontSize = 16.sp
                )
                IconButton(onClick = {

                },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = colorResource(R.color.tfColor),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .background(colorResource(R.color.tfColor),
                            RoundedCornerShape(8.dp))
                        .size(32.dp)) {
                    Icon(painter = painterResource(R.drawable.more),
                        contentDescription = null,
                        tint = Color.Unspecified)
                }
            }
            LazyColumn(modifier = Modifier
                .padding(top = 29.dp)
                .fillMaxWidth()) {
                item{
                    Column(modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .fillMaxWidth()) {
                        Row(modifier = Modifier
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Сегодняшние блюда",
                                color = Color.Black,
                                fontWeight = FontWeight(600),
                                fontFamily = poppinsFont,
                                fontSize = 16.sp
                           )
                            Button(onClick = {

                            },
                                modifier = Modifier
                                    .background(brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            colorResource(R.color.startGradient),
                                            colorResource(R.color.endGradient)
                                        )
                                    ),
                                        shape = RoundedCornerShape(50.dp)),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = Color.White
                                )
                            ) {
                                Row{
                                    Text(text = "Завтрак",
                                        color = Color.White,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight(400),
                                        fontFamily = poppinsFont,
                                        lineHeight = 15.sp
                                   )
                                    Icon(painter = painterResource(R.drawable.arrow_down),
                                        contentDescription = null,
                                        tint = Color.Unspecified,
                                        modifier = Modifier
                                            .padding(start = 5.dp))
                                }
                            }
                        }
                        Card(modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxWidth()
                            .background(Color.White,
                                RoundedCornerShape(100.dp)),
                            elevation = CardDefaults.elevatedCardElevation(
                                defaultElevation = 10.dp
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                                contentColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(100.dp)
                        ) {
                            Row(modifier = Modifier
                                .background(color = Color.White,
                                    shape = RoundedCornerShape(100.dp))) {
                                Image(painter = painterResource(R.drawable.nigiri),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(start = 24.dp)
                                        .padding(top = 20.dp)
                                        .padding(bottom = 18.dp)
                                )
                                Row(modifier = Modifier
                                    .padding(start = 24.dp)
                                    .fillMaxWidth()
                                    .align(Alignment.CenterVertically),
                                    horizontalArrangement = Arrangement.SpaceBetween) {
                                    Column{
                                        Text(
                                            text = "Лососевый нигири",
                                            color = Color.Black,
                                            fontSize = 14.sp,
                                            fontFamily = montserratRegular,
                                            fontWeight = FontWeight(500)
                                        )
                                        Text(
                                            text = "Сегодня | 7:00",
                                            color = colorResource(R.color.onBoardingText),
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(400),
                                            fontFamily = montserratRegular,
                                            modifier = Modifier
                                                .padding(top = 3.dp)
                                        )
                                    }
                                    IconButton(
                                        onClick = {

                                        },
                                        colors = IconButtonDefaults.iconButtonColors(
                                            containerColor = colorResource(R.color.endGradient),
                                            contentColor = Color.Transparent
                                        ),
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .padding(end = 15.dp)
                                            .size(26.dp)
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.bell_icon),
                                            contentDescription = null,
                                            tint = Color.Unspecified
                                        )
                                    }
                                }
                            }
                        }
                        Card(modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxWidth()
                            .background(Color.White,
                                RoundedCornerShape(100.dp)),
                            elevation = CardDefaults.elevatedCardElevation(
                                defaultElevation = 10.dp
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                                contentColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(100.dp)
                        ) {
                            Row(modifier = Modifier
                                .background(color = Color.White,
                                    shape = RoundedCornerShape(100.dp))) {
                                Image(painter = painterResource(R.drawable.glass_of_milk),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(start = 24.dp)
                                        .padding(top = 20.dp)
                                        .padding(bottom = 18.dp)
                                )
                                Row(modifier = Modifier
                                    .padding(start = 24.dp)
                                    .fillMaxWidth()
                                    .align(Alignment.CenterVertically),
                                    horizontalArrangement = Arrangement.SpaceBetween) {
                                    Column{
                                        Text(
                                            text = "Коровье молоко",
                                            color = Color.Black,
                                            fontSize = 14.sp,
                                            fontFamily = montserratRegular,
                                            fontWeight = FontWeight(500)
                                        )
                                        Text(
                                            text = "Сегодня | 8:30",
                                            color = colorResource(R.color.onBoardingText),
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(400),
                                            fontFamily = montserratRegular,
                                            modifier = Modifier
                                                .padding(top = 3.dp)
                                        )
                                    }
                                    IconButton(
                                        onClick = {

                                        },
                                        colors = IconButtonDefaults.iconButtonColors(
                                            containerColor = colorResource(R.color.endGradient),
                                            contentColor = Color.Transparent
                                        ),
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .padding(end = 15.dp)
                                            .size(26.dp)
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.bell_icon),
                                            contentDescription = null,
                                            tint = Color.Unspecified
                                        )
                                    }
                                }
                            }
                        }
                        Row(modifier = Modifier
                            .padding(top = 28.dp)
                            .fillMaxWidth()
                            .background(colorResource(R.color.mealPlannerBG),
                                shape = RoundedCornerShape(100.dp)),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Ежедневное питание",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontFamily = montserratRegular,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .padding(start = 20.dp)
                            )
                            Button(onClick = {

                            },
                                modifier = Modifier
                                    .padding(end = 14.dp)
                                    .background(color = colorResource(R.color.mealPlannerButton),
                                        shape = RoundedCornerShape(50.dp)),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = Color.White
                                )) {
                                Text(text = "Проверить",
                                    color = Color.White,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular
                               )
                            }
                        }
                    }
                }
            }
        }
    }
}