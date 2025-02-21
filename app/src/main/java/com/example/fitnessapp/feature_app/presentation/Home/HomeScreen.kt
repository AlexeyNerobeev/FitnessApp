package com.example.fitnessapp.presentation.Home

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.example.fitnessapp.feature_app.presentation.Home.components.BarChartHome
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.common.BottomAppBar
import com.example.fitnessapp.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.Home.HomeEvent
import com.example.fitnessapp.feature_app.presentation.Home.HomeVM
import com.example.fitnessapp.feature_app.presentation.Home.components.PieChartHome
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevHome() {
    val n = rememberNavController()
    HomeScreen(n)
}

@Composable
fun HomeScreen(navController: NavController, vm: HomeVM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(HomeEvent.GetName)
    if(state.error.isNotEmpty()){
        ErrorAlertDialog(state.error) {
            vm.onEvent(HomeEvent.ClearError)
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .padding(top = 40.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Добро пожаловать,",
                        color = colorResource(R.color.HomeWelcome),
                        fontFamily = montserratRegular,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400)
                    )
                    Text(
                        text = state.name,
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = montserratBold,
                        fontWeight = FontWeight(700),
                        modifier = Modifier
                            .padding(top = 5.dp)
                    )
                }
                Box(modifier = Modifier
                    .background(
                        colorResource(R.color.tfColor),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .size(40.dp, 42.dp)
                    .clickable {
                        navController.navigate(NavRoutes.Notifications.route)
                    }) {
                    Icon(
                        painter = painterResource(R.drawable.notification_icon),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    )
                }
            }
            LazyColumn(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
            ) {
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
                            PieChartHome()
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 27.dp)
                            .fillMaxWidth()
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        colorResource(R.color.todayTarget),
                                        colorResource(R.color.todayTarget)
                                    )
                                ),
                                shape = RoundedCornerShape(100.dp),
                                alpha = 0.2f
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .padding(end = 14.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Сегодняшняя цель",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontFamily = montserratRegular,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                            Button(
                                onClick = {

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
                                Text(
                                    text = "Проверить",
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
                    Box(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxWidth()
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        colorResource(R.color.startGr),
                                        colorResource(R.color.endGr)
                                    )
                                ),
                                RoundedCornerShape(20.dp),
                                alpha = 0.2f
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .padding(end = 16.dp)
                                .padding(top = 23.dp)
                        ) {
                            Text(
                                text = "Частота сердечных сокращений",
                                color = Color.Black,
                                fontWeight = FontWeight(500),
                                fontSize = 12.sp,
                                fontFamily = montserratRegular
                            )
                            BarChartHome()
                            Text(
                                text = "78 BPM",
                                style = TextStyle(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            colorResource(R.color.startGr),
                                            colorResource(R.color.endGr)
                                        )
                                    )
                                ),
                                fontFamily = montserratRegular,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(600),
                                modifier = Modifier
                                    .padding(bottom = 11.dp)
                                    .padding(top = 14.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 21.dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        colorResource(R.color.tfColor),
                                        colorResource(R.color.homeGradient)
                                    )
                                ),
                                shape = RoundedCornerShape(20.dp),
                                alpha = 0.4f
                            )
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color.White)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(start = 20.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .padding(top = 20.dp)
                                        .size(20.dp, 130.dp)
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    colorResource(R.color.tfColor),
                                                    colorResource(R.color.homeGradient)
                                                )
                                            ),
                                            shape = RoundedCornerShape(30.dp)
                                        )
                                )
                                Box(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.White,
                                                    colorResource(R.color.shadowColor)
                                                )
                                            ),
                                            shape = RoundedCornerShape(20.dp),
                                            alpha = 0.4f
                                        )
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .padding(top = 20.dp)
                                            .padding(start = 10.dp)
                                            .padding(end = 13.dp)
                                    ) {
                                        Text(
                                            text = "Вода",
                                            color = Color.Black,
                                            fontWeight = FontWeight(500),
                                            fontFamily = montserratRegular,
                                            fontSize = 12.sp
                                        )
                                        Text(
                                            text = "4 Литра",
                                            style = TextStyle(
                                                brush = Brush.horizontalGradient(
                                                    colors = listOf(
                                                        colorResource(R.color.startGradient),
                                                        colorResource(R.color.endGradient)
                                                    )
                                                )
                                            ),
                                            fontSize = 14.sp,
                                            fontFamily = montserratBold,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier
                                                .padding(top = 5.dp)
                                        )
                                        Text(
                                            text = "В реал. времени",
                                            color = colorResource(R.color.onBoardingText),
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight(400),
                                            fontFamily = montserratRegular,
                                            modifier = Modifier
                                                .padding(top = 10.dp)
                                        )
                                        Row(
                                            modifier = Modifier
                                                .padding(top = 5.dp)
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(6.dp)
                                                    .clip(CircleShape)
                                                    .background(
                                                        brush = Brush.horizontalGradient(
                                                            colors = listOf(
                                                                colorResource(R.color.startGradient),
                                                                colorResource(R.color.endGradient)
                                                            )
                                                        ), alpha = 0.5f
                                                    )
                                            )
                                            Text(
                                                text = "6:00 - 8:00",
                                                color = colorResource(R.color.HomeWelcome),
                                                fontSize = 8.sp,
                                                fontFamily = montserratRegular,
                                                fontWeight = FontWeight(400),
                                                modifier = Modifier
                                                    .padding(start = 8.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        Box(
                            modifier = Modifier
                                .padding(start = 15.dp)
                                .height(150.dp)
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color.White,
                                            colorResource(R.color.shadowColor)
                                        )
                                    ),
                                    shape = RoundedCornerShape(20.dp),
                                    alpha = 0.4f
                                )
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .padding(start = 20.dp)
                            ) {
                                Text(
                                    text = "Сон",
                                    color = Color.Black,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = montserratRegular
                                )
                                Text(text = "8 ч. 20 мин.",
                                    style = TextStyle(
                                        brush = Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGradient),
                                                colorResource(R.color.endGradient)
                                            )
                                        )
                                    )
                                )
                                Image(painter = painterResource(R.drawable.sleep_graph),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(top = 5.dp)
                                        .padding(end = 20.dp))
                            }
                        }
                    }
                }
                item {
                    Box(modifier = Modifier
                        .height(100.dp)
                        .background(Color.Transparent)
                    )
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            BottomAppBar(navController, 1)
        }
    }
}