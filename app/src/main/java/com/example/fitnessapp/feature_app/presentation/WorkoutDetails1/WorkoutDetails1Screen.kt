package com.example.fitnessapp.feature_app.presentation.WorkoutDetails1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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
import com.example.fitnessapp.R
import com.example.fitnessapp.common.TopAppBar
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevWorkoutDetails1Screen(){
    WorkoutDetails1Screen(rememberNavController())
}

@Composable
fun WorkoutDetails1Screen(navController: NavController, vm: WorkoutDetails1VM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(WorkoutDetails1Event.GetWorkoutData)
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Box(modifier = Modifier
                .background(Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(R.color.startGr),
                        colorResource(R.color.endGr)
                    )
                ))
            ){
                Column(modifier = Modifier
                    .padding(horizontal = 30.dp)) {
                    TopAppBar(navController, "", Color.Transparent)
                    Image(painter = painterResource(R.drawable.workout_details_main_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally))
                }
            }
            Box(modifier = Modifier
                .offset(y = 346.dp)
                .fillMaxSize()
                .background(Color.White,
                    RoundedCornerShape(40.dp)
                )
            ){
                Column(modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier
                        .size(50.dp, 5.dp)
                        .background(Color.Black.copy(alpha = 0.1f),
                            RoundedCornerShape(50.dp)
                        )
                    )
                    Row(modifier = Modifier
                        .padding(top = 25.dp)
                        .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = state.name,
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                fontFamily = montserratBold
                            )
                            Text(text = state.description,
                                color = colorResource(R.color.onBoardingText),
                                fontFamily = montserratRegular,
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                        }
                        Box(modifier = Modifier
                            .fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd){
                            IconButton(onClick = {

                            },
                                modifier = Modifier
                                    .size(32.dp)
                                    .background(Color.White,
                                        RoundedCornerShape(8.dp))) {
                                Icon(painter = painterResource(R.drawable.heart_icon),
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