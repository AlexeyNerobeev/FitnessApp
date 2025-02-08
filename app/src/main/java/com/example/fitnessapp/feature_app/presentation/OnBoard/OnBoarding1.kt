package com.example.fitnessapp.presentation.OnBoard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.example.fitnessapp.data.sharedPreferences.SharedPreferences
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular

@Preview
@Composable
fun PrevOnB1(){
    val n = rememberNavController()
    val vm = OnBoardVM()
    OnBoarding1(n, vm)
}

@Composable
fun OnBoarding1(navController: NavController, vm: OnBoardVM){
    val prefs = SharedPreferences(LocalContext.current)
    prefs.SavePreferences(1)
    Scaffold(modifier = Modifier
        .fillMaxSize()) {innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { distance ->
                    vm.swipe = distance <= -100
                    if(vm.swipe)
                        navController.navigate(NavRoutes.OnBoarding2.route)
                }
            )) {
            Image(painter = painterResource(R.drawable.onb1_art),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Text(text = "Отслеживайте свою цель",
                color = Color.Black,
                fontFamily = montserratBold,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier
                    .padding(start = 30.dp)
                    .padding(top = 24.dp)
            )
            Text(text = "Не волнуйтесь, если у вас возникли проблемы с определением ваших целей. Мы можем помочь вам определить ваши цели и отслеживать их.",
                color = colorResource(R.color.onBoardingText),
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                fontFamily = montserratRegular,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .padding(top = 10.dp)
           )
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomEnd){
                IconButton(onClick = {
                    navController.navigate(NavRoutes.OnBoarding2.route)
                },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                        .padding(end = 30.dp)
                        .background(brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.startGradient),
                                colorResource(R.color.endGradient)
                            )
                        ),
                            shape = CircleShape
                        )
                        .size(60.dp)) {
                    Icon(painter = painterResource(R.drawable.arrow),
                        contentDescription = null,
                        tint = Color.White)
                }
            }
        }
    }
}