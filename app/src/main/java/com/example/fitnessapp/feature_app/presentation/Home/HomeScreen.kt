package com.example.fitnessapp.presentation.Home

import android.graphics.Typeface
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import co.yml.charts.common.model.PlotData
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.example.fitnessapp.R
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import com.example.fitnessapp.ui.theme.FitnessAppTheme

@Preview
@Composable
fun PrevHome(){
    val n = rememberNavController()
    HomeScreen(n)
}

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(modifier = Modifier.fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Row(modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(top = 40.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Column{
                    Text(text = "Добро пожаловать,",
                        color = colorResource(R.color.HomeWelcome),
                        fontFamily = montserratRegular,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400)
                    )
                    Text(text = "Юрий",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = montserratBold,
                        fontWeight = FontWeight(700),
                        modifier = Modifier
                            .padding(top = 5.dp))
                }
                Box(modifier = Modifier
                    .background(
                        colorResource(R.color.tfColor),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .size(40.dp, 42.dp)
                    .clickable {

                    }){
                    Icon(painter = painterResource(R.drawable.notification_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.BottomCenter))
                }
            }
            LazyColumn(modifier = Modifier
                .padding(top = 30.dp)
                .padding(horizontal = 30.dp)
                .fillMaxWidth()){
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        colorResource(R.color.startGr),
                                        colorResource(R.color.endGr)
                                    )
                                ),
                                shape = RoundedCornerShape(22.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .padding(end = 29.dp)
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(top = 26.dp)
                            ) {
                                Text(
                                    text = "ИМТ (индекс массы тела)",
                                    color = Color.White,
                                    fontSize = 13.sp,
                                    fontFamily = montserratBold,
                                    fontWeight = FontWeight(600)
                                )
                                Text(
                                    text = "У тебя нормальный вес",
                                    color = Color.White,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    fontSize = 12.sp
                                )
                                Button(
                                    onClick = {

                                    },
                                    modifier = Modifier
                                        .padding(top = 15.dp)
                                        .padding(bottom = 26.dp)
                                        .background(
                                            brush = Brush.horizontalGradient(
                                                colors = listOf(
                                                    colorResource(R.color.startGradient),
                                                    colorResource(R.color.endGradient)
                                                )
                                            ),
                                            shape = RoundedCornerShape(50.dp)
                                        )
                                        .size(95.dp, 35.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent,
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text(
                                        text = "Больше",
                                        color = Color.White,
                                        fontSize = 10.sp,
                                        fontFamily = montserratBold,
                                        fontWeight = FontWeight(600)
                                    )
                                }
                            }
                            val pieChartData = PieChartData(
                                slices = listOf(
                                    PieChartData.Slice("ИМТ",
                                        20.1f,
                                        colorResource(R.color.startGradient)
                                    ),
                                    PieChartData.Slice("Other",
                                        79.9f,
                                        Color.Blue)
                                ),
                                plotType = PlotType.Pie
                            )
                            val pieChartConfig = PieChartConfig(
                                labelVisible = false,
                                activeSliceAlpha = .9f,
                                isEllipsizeEnabled = true,
                                backgroundColor = Color.Transparent,
                                showSliceLabels = false,
                                chartPadding = 0
                            )
                            PieChart(
                                modifier = Modifier
                                    .padding(vertical = 29.dp)
                                    .size(88.dp),
                                pieChartData,
                                pieChartConfig
                            )
                        }
                    }
                    Box(modifier = Modifier
                        .padding(top = 27.dp)
                        .fillMaxWidth()
                        .background(
                            colorResource(R.color.endGradient),
                            shape = RoundedCornerShape(100.dp)
                        )){
                        Row(modifier = Modifier
                            .padding(start = 20.dp)
                            .padding(end = 14.dp)
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween){
                            Text(text = "Сегодняшняя цель",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontFamily = montserratRegular,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                            Button(onClick = {

                            },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = Color.White
                                ),
                                modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .background(
                                        colorResource(R.color.mealPlannerButton),
                                        shape = RoundedCornerShape(100.dp)
                                    )
                                    ) {
                                Text(text = "Проверить",
                                    color = Color.White,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                               )
                            }
                        }
                    }
                    Text(
                        text = "Статус активности",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = montserratBold,
                        fontWeight = FontWeight(600),
                        modifier = Modifier
                            .padding(top = 37.dp)
                    )
                    Box(modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                        .background(brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.startGr),
                                colorResource(R.color.endGr)
                            )
                        ),
                            RoundedCornerShape(20.dp))
                    ){
                        Column(modifier = Modifier
                            .padding(start = 20.dp)
                            .padding(end = 16.dp)
                            .padding(top = 23.dp)) {
                            Text(text = "Частота сердечных сокращений",
                                color = Color.Black,
                                fontWeight = FontWeight(500),
                                fontSize = 12.sp,
                                fontFamily = montserratRegular
                            )
                            Image(painter = painterResource(R.drawable.heart_rate),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}