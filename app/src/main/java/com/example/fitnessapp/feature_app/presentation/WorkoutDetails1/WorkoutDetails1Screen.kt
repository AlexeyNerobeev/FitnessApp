package com.example.fitnessapp.feature_app.presentation.WorkoutDetails1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
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
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.common.ErrorAlertDialog
import com.example.fitnessapp.common.TopAppBar
import com.example.fitnessapp.feature_app.presentation.WorkoutDetails1.components.Exerсise
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevWorkoutDetails1Screen() {
    WorkoutDetails1Screen(rememberNavController())
}

@Composable
fun WorkoutDetails1Screen(navController: NavController, vm: WorkoutDetails1VM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(WorkoutDetails1Event.GetWorkoutData)
    LaunchedEffect(key1 = !state.congratulation) {
        if(state.congratulation){
            navController.navigate(NavRoutes.Congratulation.route)
        }
    }
    if(state.error.isNotEmpty()){
        ErrorAlertDialog(state.error) {
            vm.onEvent(WorkoutDetails1Event.ClearError)
        }
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.startGr),
                                colorResource(R.color.endGr)
                            )
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                ) {
                    TopAppBar(navController, "", Color.Transparent)
                    Image(
                        painter = painterResource(R.drawable.workout_details_main_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .offset(y = 346.dp)
                    .fillMaxSize()
                    .background(
                        Color.White,
                        RoundedCornerShape(40.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 30.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp, 5.dp)
                            .background(
                                Color.Black.copy(alpha = 0.1f),
                                RoundedCornerShape(50.dp)
                            )
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 25.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = state.name,
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                fontFamily = montserratBold
                            )
                            Text(
                                text = state.description,
                                color = colorResource(R.color.onBoardingText),
                                fontFamily = montserratRegular,
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            IconButton(
                                onClick = {

                                },
                                modifier = Modifier
                                    .size(32.dp)
                                    .background(
                                        Color.White,
                                        RoundedCornerShape(8.dp)
                                    )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.heart_icon),
                                    contentDescription = null,
                                    tint = Color.Unspecified
                                )
                            }
                        }
                    }
                    LazyColumn(
                        modifier = Modifier
                            .padding(top = 20.dp)
                    ) {
                        item {
                            Box(
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .fillMaxWidth()
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startWorkGr),
                                                colorResource(R.color.endWorkGr)
                                            )
                                        ),
                                        RoundedCornerShape(16.dp),
                                        alpha = 0.2f
                                    )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(horizontal = 15.dp)
                                        .padding(vertical = 14.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.calendar_icon),
                                        contentDescription = null,
                                        tint = Color.Unspecified
                                    )
                                    Text(
                                        text = "Время тренировки",
                                        color = colorResource(R.color.onBoardingText),
                                        fontFamily = montserratRegular,
                                        fontWeight = FontWeight(400),
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .padding(start = 10.dp)
                                    )
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(
                                                text = state.date,
                                                color = colorResource(R.color.onBoardingText),
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight(400),
                                                fontFamily = montserratRegular
                                            )
                                            Icon(
                                                painter = painterResource(R.drawable.arrow),
                                                contentDescription = null,
                                                tint = colorResource(R.color.onBoardingText),
                                                modifier = Modifier
                                                    .padding(start = 10.dp)
                                                    .padding(end = 15.dp)
                                            )
                                        }
                                    }
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .fillMaxWidth()
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGr),
                                                colorResource(R.color.endGr)
                                            )
                                        ),
                                        RoundedCornerShape(16.dp),
                                        alpha = 0.2f
                                    )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(horizontal = 15.dp)
                                        .padding(vertical = 14.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.dificulty_icon),
                                        contentDescription = null,
                                        tint = Color.Unspecified
                                    )
                                    Text(
                                        text = "Сложность",
                                        color = colorResource(R.color.onBoardingText),
                                        fontFamily = montserratRegular,
                                        fontWeight = FontWeight(400),
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .padding(start = 10.dp)
                                    )
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(
                                                text = state.complexity,
                                                color = colorResource(R.color.onBoardingText),
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight(400),
                                                fontFamily = montserratRegular
                                            )
                                            Icon(
                                                painter = painterResource(R.drawable.arrow),
                                                contentDescription = null,
                                                tint = colorResource(R.color.onBoardingText),
                                                modifier = Modifier
                                                    .padding(start = 10.dp)
                                                    .padding(end = 15.dp)
                                            )
                                        }
                                    }
                                }
                            }
                            Column(modifier = Modifier
                                .padding(top = 30.dp)
                                .fillMaxWidth()) {
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                ){
                                    Text(text = "Вам понадобится",
                                        color = Color.Black,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(600),
                                        fontFamily = montserratBold
                                   )
                                    Box(modifier = Modifier
                                        .fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd){
                                        Text(text = "5 предметов",
                                            color = colorResource(R.color.HomeWelcome),
                                            fontFamily = montserratRegular,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(500)
                                        )
                                    }
                                }
                                LazyRow(modifier = Modifier
                                    .padding(top = 15.dp)
                                    .fillMaxWidth()) {
                                    item {
                                        Column {
                                            Box(modifier = Modifier
                                                .size(130.dp)
                                                .padding(end = 15.dp)
                                                .background(colorResource(R.color.tfColor),
                                                    RoundedCornerShape(12.dp)),
                                                contentAlignment = Alignment.Center
                                            ){
                                                Image(painter = painterResource(R.drawable.barbel),
                                                    contentDescription = null)
                                            }
                                            Text(text = "Гантели",
                                                color = Color.Black,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight(400),
                                                fontFamily = montserratRegular,
                                                modifier = Modifier.padding(top = 10.dp)
                                           )
                                        }
                                        Column {
                                            Box(modifier = Modifier
                                                .size(130.dp)
                                                .padding(end = 15.dp)
                                                .background(colorResource(R.color.tfColor),
                                                    RoundedCornerShape(12.dp)),
                                                contentAlignment = Alignment.Center
                                            ){
                                                Image(painter = painterResource(R.drawable.skipping_rope),
                                                    contentDescription = null)
                                            }
                                            Text(text = "Скакалка",
                                                color = Color.Black,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight(400),
                                                fontFamily = montserratRegular,
                                                modifier = Modifier.padding(top = 10.dp)
                                            )
                                        }
                                        Column {
                                            Box(modifier = Modifier
                                                .size(130.dp)
                                                .padding(end = 15.dp)
                                                .background(colorResource(R.color.tfColor),
                                                    RoundedCornerShape(12.dp)),
                                                contentAlignment = Alignment.Center
                                            ){
                                                Image(painter = painterResource(R.drawable.baseline_battery_full_24),
                                                    contentDescription = null,
                                                    modifier = Modifier.size(25.dp, 75.dp)
                                                )
                                            }
                                            Text(text = "Бутылка",
                                                color = Color.Black,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight(400),
                                                fontFamily = montserratRegular,
                                                modifier = Modifier.padding(top = 10.dp)
                                            )
                                        }
                                    }
                                }
                                Column(modifier = Modifier
                                    .padding(top = 30.dp)
                                    .fillMaxWidth()) {
                                    Row(modifier = Modifier
                                        .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically){
                                        Text(text = "Упражнения",
                                            color = Color.Black,
                                            fontSize = 16.sp,
                                            fontFamily = montserratBold,
                                            fontWeight = FontWeight(600)
                                        )
                                        Text(text = "3 подхода",
                                            color = colorResource(R.color.HomeWelcome),
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(500),
                                            fontFamily = montserratRegular
                                       )
                                    }
                                    Column(modifier = Modifier
                                        .padding(top = 20.dp)
                                        .fillMaxWidth()) {
                                        Text(text = "Подход 1",
                                            color = Color.Black,
                                            fontFamily = montserratRegular,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(500)
                                        )
                                        Exerсise(painterResource(R.drawable.run_ex),
                                            "Бег",
                                            "05:00")
                                        Exerсise(painterResource(R.drawable.jump_ex),
                                            "Прыжки",
                                            "12x")
                                        Exerсise(painterResource(R.drawable.skipping_ex),
                                            "Скакалка",
                                            "15x")
                                        Exerсise(painterResource(R.drawable.squats_ex),
                                            "приседания",
                                            "20x")
                                        Exerсise(painterResource(R.drawable.hands_up_ex),
                                            "Подъемы рук",
                                            "00:53")
                                        Exerсise(painterResource(R.drawable.chill_ex),
                                            "Отдых и напитки",
                                            "02:00")
                                        Text(text = "Подход 2",
                                            color = Color.Black,
                                            fontFamily = montserratRegular,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(500),
                                            modifier = Modifier
                                                .padding(top = 20.dp)
                                        )
                                        Exerсise(painterResource(R.drawable.bent_pushup_ex),
                                            "Отжимания в наклоне",
                                            "12x")
                                        Exerсise(painterResource(R.drawable.pushup_ex),
                                            "Отжимания",
                                            "15x")
                                        Exerсise(painterResource(R.drawable.skipping_ex),
                                            "Скакалка",
                                            "15x")
                                    }
                                }
                            }
                        }
                        item{
                            Box(modifier = Modifier
                                .height(500.dp))
                        }
                    }
                }
            }
        }
    }
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter){
        Button(onClick = {
            vm.onEvent(WorkoutDetails1Event.SaveCompleteWorkout)
        },
            modifier = Modifier
                .padding(bottom = 40.dp)
                .padding(horizontal = 30.dp)
                .fillMaxWidth()
                .height(60.dp)
                .background(Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(R.color.startGradient),
                        colorResource(R.color.endGradient)
                    )
                ),
                    shape = RoundedCornerShape(99.dp)
                ),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Transparent,
                containerColor = Color.Transparent
            )
        ) {
            Text(text = "Начать",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                fontFamily = montserratBold
           )
        }
    }
}