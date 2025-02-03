package com.example.fitnessapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

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

                            }) {
                                Row(modifier = Modifier
                                    .padding(start = 17.dp)
                                    .padding(end = 10.dp)
                                    .width(60.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text(text = "Завтрак",
                                        color = Color.White,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight(400),
                                        fontFamily = poppinsFont
                                   )
                                    Icon(painter = painterResource(R.drawable.arrow_down),
                                        contentDescription = null,
                                        tint = Color.Unspecified)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}