package com.example.fitnessapp.feature_app.presentation.WorkoutTracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
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
import com.example.fitnessapp.feature_app.presentation.common.TopAppBar
import com.example.fitnessapp.feature_app.presentation.ActivityTracker.components.BarChartActivityTracker
import com.example.fitnessapp.feature_app.presentation.WorkoutTracker.components.BarChartWorkoutTracker
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import com.example.fitnessapp.presentation.WelcomeScreen.poppinsFont
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevWorkoutTrackerScreen(){
    WorkoutTrackerScreen(rememberNavController())
}

@Composable
fun WorkoutTrackerScreen(navController: NavController, vm: WorkoutVM = koinViewModel()) {
    val state = vm.state.value
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.workoutColor))){
                Column (modifier = Modifier
                    .padding(horizontal = 30.dp)){
                    TopAppBar(navController = navController, "Трекер тренировок", Color.White)
//                    Image(painter = painterResource(R.drawable.workout_tracker_graph),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .padding(horizontal = 30.dp)
//                            .padding(top = 31.dp)
//                            .fillMaxWidth(),
//                        contentScale = ContentScale.Crop)
                    Spacer(modifier = Modifier.height(31.dp))
                    BarChartWorkoutTracker()
                    Box(modifier = Modifier
                        .padding(top = 21.dp)
                        .padding(bottom = 51.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(Color.White,
                            RoundedCornerShape(8.dp))
                    ){
                        Column(modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(start = 10.dp)
                        ) {
                            Row {
                                Column {
                                    Text(
                                        text = "Пят, 28 мая",
                                        color = colorResource(R.color.HomeWelcome),
                                        fontFamily = montserratRegular,
                                        fontWeight = FontWeight(400),
                                        fontSize = 8.sp
                                    )
                                    Text(
                                        text = "Вверх тела",
                                        color = colorResource(R.color.HomeWelcome),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight(400),
                                        fontFamily = montserratRegular,

                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .padding(start = 17.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "90%",
                                        color = colorResource(R.color.improveColor),
                                        fontWeight = FontWeight(400),
                                        fontSize = 8.sp,
                                        fontFamily = poppinsFont
                                    )
                                    Icon(
                                        painter = painterResource(R.drawable.up),
                                        contentDescription = null,
                                        tint = Color.Unspecified
                                    )
                                }
                            }
                            Image(
                                painter = painterResource(R.drawable.progress_bar),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(top = 6.dp)
                                    .padding(end = 10.dp)
                                    .padding(bottom = 10.dp)
                            )
                        }
                    }
                }
            }
            Box(modifier = Modifier
                .offset(y = 375.dp)
                .fillMaxSize()
                .background(Color.White,
                    RoundedCornerShape(40.dp))
                .align(Alignment.BottomCenter)
                ){
                Column(modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
                    ) {
                    Box(modifier = Modifier
                        .size(50.dp, 5.dp)
                        .background(Color.Black.copy(alpha = 0.1f),
                            RoundedCornerShape(50.dp)
                        )
                        .align(Alignment.CenterHorizontally)
                    )
                    Box(modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                        .background(colorResource(R.color.trainingSchedule),
                            RoundedCornerShape(100.dp))
                    ){
                        Row(modifier = Modifier
                            .padding(top = 15.dp)
                            .padding(start = 20.dp)
                            .padding(end = 14.dp)
                            .padding(bottom = 14.dp)
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = "Рассписание трен.",
                                color = Color.Black,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = montserratRegular
                           )
                            Box(modifier = Modifier
                                .size(96.dp, 28.dp)
                                .background(colorResource(R.color.workoutColor),
                                    RoundedCornerShape(100.dp)
                                )
                                .clickable {
                                navController.navigate(NavRoutes.WorkoutSchedule.route)
                                },
                                contentAlignment = Alignment.Center
                            ){
                                Text(text = "Проверить",
                                    color = Color.White,
                                    fontFamily = montserratRegular,
                                    fontWeight = FontWeight(400),
                                    fontSize = 11.sp
                                )
                            }
                        }
                    }
                    LazyColumn(modifier = Modifier
                        .padding(top = 40.dp)
                        .fillMaxSize()) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Тренировка",
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontFamily = montserratBold,
                                    fontWeight = FontWeight(600)
                                )
                                Text(
                                    text = "Больше",
                                    color = colorResource(R.color.HomeWelcome),
                                    fontWeight = FontWeight(500),
                                    fontSize = 12.sp,
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .clickable {  }
                                )
                            }
                            ElevatedCard(
                                modifier = Modifier
                                    .padding(top = 15.dp)
                                    .fillMaxWidth()
                                    .background(
                                        colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                        RoundedCornerShape(16.dp)
                                    ),
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 10.dp
                                ),
                                colors = CardDefaults.cardColors(
                                    contentColor = Color.Transparent,
                                    containerColor = Color.White
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(horizontal = 15.dp)
                                        .padding(vertical = 15.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.whole_body),
                                        contentDescription = null
                                    )
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Все тело",
                                            color = Color.Black,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(500),
                                            fontFamily = montserratRegular
                                        )
                                        Text(
                                            text = "Сегодня, 15:00",
                                            color = colorResource(R.color.HomeWelcome),
                                            fontFamily = montserratRegular,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight(400)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        Switch(
                                            checked = state.checkAll,
                                            onCheckedChange = { vm.onEvent(WorkoutEvent.IsCheckedAll) },
                                            modifier = Modifier
                                                .size(44.dp, 24.dp),
                                            colors = SwitchDefaults.colors(
                                                uncheckedThumbColor = Color.White,
                                                checkedThumbColor = Color.White,
                                                checkedTrackColor = colorResource(R.color.startGradient),
                                                uncheckedTrackColor = colorResource(R.color.uncheckedSwitch)
                                            )
                                        )
                                    }
                                }
                            }
                            ElevatedCard(
                                modifier = Modifier
                                    .padding(top = 15.dp)
                                    .fillMaxWidth()
                                    .background(
                                        colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                        RoundedCornerShape(16.dp)
                                    ),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Transparent
                                ),
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 10.dp
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(horizontal = 15.dp)
                                        .padding(vertical = 15.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.upper_part),
                                        contentDescription = null
                                    )
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Вверхняя часть",
                                            color = Color.Black,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(500),
                                            fontFamily = montserratRegular
                                        )
                                        Text(
                                            text = "Завтра, 18:00",
                                            color = colorResource(R.color.HomeWelcome),
                                            fontFamily = montserratRegular,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight(400)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        Switch(
                                            checked = state.checkUp,
                                            onCheckedChange = { vm.onEvent(WorkoutEvent.IsCheckedUp) },
                                            modifier = Modifier
                                                .size(44.dp, 24.dp),
                                            colors = SwitchDefaults.colors(
                                                uncheckedThumbColor = Color.White,
                                                checkedThumbColor = Color.White,
                                                checkedTrackColor = colorResource(R.color.startGradient),
                                                uncheckedTrackColor = colorResource(R.color.uncheckedSwitch)
                                            )
                                        )
                                    }
                                }
                            }
                            Column(modifier = Modifier
                                .padding(top = 30.dp)
                                .fillMaxWidth()) {
                                Text(text = "Что вы хотите тренировать",
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(600),
                                    fontFamily = montserratBold
                               )
                                Box(modifier = Modifier
                                    .padding(top = 15.dp)
                                    .fillMaxWidth()
                                    .background(colorResource(R.color.trainingCard).copy(alpha = 0.2f),
                                        RoundedCornerShape(20.dp)
                                    )
                                ){
                                    Row(modifier = Modifier
                                        .padding(horizontal = 20.dp),
                                        verticalAlignment = Alignment.CenterVertically) {
                                        Column(modifier = Modifier
                                            .padding(top = 20.dp)) {
                                            Text(text = "Все тело",
                                                color = Color.Black,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight(500),
                                                fontFamily = montserratRegular
                                           )
                                            Text(text = "11 упражнений | 32 минут",
                                                color = colorResource(R.color.notificationTime),
                                                fontFamily = montserratRegular,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight(400),
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                            Box(modifier = Modifier
                                                .padding(top = 15.dp)
                                                .padding(bottom = 18.dp)
                                                .size(94.dp, 35.dp)
                                                .background(Color.White,
                                                    RoundedCornerShape(50.dp)
                                                )
                                                .clickable {
                                                    navController.navigate(NavRoutes.WorkoutDetails1.route)
                                                },
                                                contentAlignment = Alignment.Center
                                            ){
                                                Text(text = "Больше",
                                                    color = colorResource(R.color.trainingCard),
                                                    fontSize = 10.sp,
                                                    fontFamily = montserratRegular,
                                                    fontWeight = FontWeight(500)
                                                )
                                            }
                                        }
                                        Box(modifier = Modifier
                                            .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd){
                                            Box(contentAlignment = Alignment.Center){
                                                Box(modifier = Modifier
                                                    .size(92.dp)
                                                    .background(Color.White,
                                                        CircleShape
                                                    )
                                                )
                                                Image(painter = painterResource(R.drawable.worktr_icon1),
                                                    contentDescription = null)
                                            }
                                        }
                                    }
                                }
                                Box(modifier = Modifier
                                    .padding(top = 19.dp)
                                    .fillMaxWidth()
                                    .background(colorResource(R.color.trainingCard).copy(alpha = 0.2f),
                                        RoundedCornerShape(20.dp)
                                    )
                                ){
                                    Row(modifier = Modifier
                                        .padding(horizontal = 20.dp),
                                        verticalAlignment = Alignment.CenterVertically) {
                                        Column(modifier = Modifier
                                            .padding(top = 20.dp)) {
                                            Text(text = "Нижняя часть",
                                                color = Color.Black,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight(500),
                                                fontFamily = montserratRegular
                                            )
                                            Text(text = "12 упражнений | 40 минут",
                                                color = colorResource(R.color.notificationTime),
                                                fontFamily = montserratRegular,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight(400),
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                            Box(modifier = Modifier
                                                .padding(top = 15.dp)
                                                .padding(bottom = 18.dp)
                                                .size(94.dp, 35.dp)
                                                .background(Color.White,
                                                    RoundedCornerShape(50.dp)
                                                )
                                                .clickable {  },
                                                contentAlignment = Alignment.Center
                                            ){
                                                Text(text = "Больше",
                                                    color = colorResource(R.color.trainingCard),
                                                    fontSize = 10.sp,
                                                    fontFamily = montserratRegular,
                                                    fontWeight = FontWeight(500)
                                                )
                                            }
                                        }
                                        Box(modifier = Modifier
                                            .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd){
                                            Box(contentAlignment = Alignment.Center){
                                                Box(modifier = Modifier
                                                    .size(92.dp)
                                                    .background(Color.White,
                                                        CircleShape
                                                    )
                                                )
                                                Image(painter = painterResource(R.drawable.worktr_icon2),
                                                    contentDescription = null)
                                            }
                                        }
                                    }
                                }
                                Box(modifier = Modifier
                                    .padding(top = 15.dp)
                                    .fillMaxWidth()
                                    .background(colorResource(R.color.trainingCard).copy(alpha = 0.2f),
                                        RoundedCornerShape(20.dp)
                                    )
                                ){
                                    Row(modifier = Modifier
                                        .padding(horizontal = 20.dp),
                                        verticalAlignment = Alignment.CenterVertically) {
                                        Column(modifier = Modifier
                                            .padding(top = 20.dp)) {
                                            Text(text = "Пресс",
                                                color = Color.Black,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight(500),
                                                fontFamily = montserratRegular
                                            )
                                            Text(text = "14 упражнений | 20 минут",
                                                color = colorResource(R.color.notificationTime),
                                                fontFamily = montserratRegular,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight(400),
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                            Box(modifier = Modifier
                                                .padding(top = 15.dp)
                                                .padding(bottom = 18.dp)
                                                .size(94.dp, 35.dp)
                                                .background(Color.White,
                                                    RoundedCornerShape(50.dp)
                                                )
                                                .clickable {  },
                                                contentAlignment = Alignment.Center
                                            ){
                                                Text(text = "Больше",
                                                    color = colorResource(R.color.trainingCard),
                                                    fontSize = 10.sp,
                                                    fontFamily = montserratRegular,
                                                    fontWeight = FontWeight(500)
                                                )
                                            }
                                        }
                                        Box(modifier = Modifier
                                            .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd){
                                            Box(contentAlignment = Alignment.Center){
                                                Box(modifier = Modifier
                                                    .size(92.dp)
                                                    .background(Color.White,
                                                        CircleShape
                                                    )
                                                )
                                                Image(painter = painterResource(R.drawable.worktr_icon3),
                                                    contentDescription = null)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        item{
                            Box(modifier = Modifier
                                .height(400.dp))
                        }
                    }
                }
            }
        }
    }
}