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
import com.example.fitnessapp.feature_app.presentation.OnBoard.OnBoardingEvent
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevOnB3(){
    val n = rememberNavController()
    OnBoarding3(n)
}

@Composable
fun OnBoarding3(navController: NavController, vm: OnBoardVM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(OnBoardingEvent.ChangePref(3))
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { distance ->
                    vm.onEvent(OnBoardingEvent.Swipe(distance <= -100))
                    if(state.swipe)
                        navController.navigate(NavRoutes.OnBoarding4.route)
                }
            )) {
            Image(painter = painterResource(R.drawable.onb3_art),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth())
            Column(modifier = Modifier
                .padding(top = 33.dp)
                .padding(horizontal = 30.dp)) {
                Text(text = "Питайся правильно",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontFamily = montserratBold,
                    fontWeight = FontWeight(700)
                )
                Text(text = "Давайте начнем здоровый образ жизни вместе с нами, мы сможем определять ваш рацион каждый день. Здоровое питание - это весело",
                    color = colorResource(R.color.onBoardingText),
                    fontSize = 14.sp,
                    fontFamily = montserratRegular,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(top = 15.dp)
                )
            }
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomEnd){
                IconButton(onClick = {
                    navController.navigate(NavRoutes.OnBoarding4.route)
                },
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                        .padding(end = 30.dp)
                        .background(brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.startGradient),
                                colorResource(R.color.endGradient)
                            )
                        ),
                            shape = CircleShape)
                        .size(60.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    )) {
                    Icon(painter = painterResource(R.drawable.arrow),
                        contentDescription = null,
                        tint = Color.White)
                }
            }
        }
    }
}