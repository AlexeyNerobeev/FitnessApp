package com.example.fitnessapp.presentation.Target

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.feature_app.presentation.Target.TargetEvent
import com.example.fitnessapp.feature_app.presentation.Target.components.Card2
import com.example.fitnessapp.feature_app.presentation.Target.components.Card3
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevTarget(){
    val n = rememberNavController()
    TargetScreen(n)
}

@Composable
fun TargetScreen(navController: NavController, vm: TargetVM = koinViewModel()) {
    val state = vm.state.value
    LaunchedEffect(key1 = !state.isComplete) {
        if(state.isComplete){
            navController.navigate(NavRoutes.SuccessRegistration.route)
        }
    }
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
                    .clickable {
                        vm.onEvent(TargetEvent.TapLeft)
                    }
                )
                Box(modifier = Modifier
                    .align(Alignment.Center)){
                    when(state.cardNumber){
                        1 -> Card1()
                        2 -> Card2()
                        3 -> Card3()
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
                    .clickable {
                        vm.onEvent(TargetEvent.TapRight)
                    }
                )
            }
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter){
                Button(onClick = {
                    vm.onEvent(TargetEvent.AddTarget)
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