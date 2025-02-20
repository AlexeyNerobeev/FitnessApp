package com.example.fitnessapp.feature_app.presentation.WorkoutTracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.common.TopAppBar
import com.example.fitnessapp.feature_app.presentation.ActivityTracker.components.BarChartActivityTracker
import com.example.fitnessapp.feature_app.presentation.WorkoutTracker.components.BarChartWorkoutTracker
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import com.example.fitnessapp.presentation.WelcomeScreen.poppinsFont

@Preview
@Composable
fun PrevWorkoutTrackerScreen(){
    WorkoutTrackerScreen(rememberNavController())
}

@Composable
fun WorkoutTrackerScreen(navController: NavController) {
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
                .fillMaxWidth()
                .background(Color.White,
                    RoundedCornerShape(40.dp))){
                Column(modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
                    ) {
                    Box(modifier = Modifier
                        .size(50.dp, 5.dp)
                        .background(Color.Black,
                            RoundedCornerShape(50.dp)
                        )
                    )
                }
            }
        }
    }
}