package com.example.fitnessapp.presentation.WelcomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.WelcomeScreen.WelcomeEvent
import com.example.fitnessapp.feature_app.presentation.WelcomeScreen.WelcomeVM
import org.koin.androidx.compose.koinViewModel

val montserratRegular = FontFamily(
    Font(
       resId = R.font.montserratregular
    )
)

val poppinsFont = FontFamily(
    Font(
        resId = R.font.poppinsregular
    )
)

@Preview
@Composable
fun PrevWelcome(){
    val n = rememberNavController()
    WelcomeScreen(n)
}

@Composable
fun WelcomeScreen(navController: NavController, vm: WelcomeVM = koinViewModel()) {
    val state = vm.state.value
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            vm.onEvent(WelcomeEvent.GetNumber)
            Image(painter = painterResource(R.drawable.app_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 83.dp)
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
                )
            Image(painter = painterResource(R.drawable.app_name),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(Alignment.CenterHorizontally))
            Text(text = "Каждый может тренироваться",
                color = colorResource(R.color.welcomeText),
                fontSize = 18.sp,
                fontFamily = montserratRegular,
                fontWeight = FontWeight(400),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally))
            Box(modifier = Modifier
                .fillMaxSize()){
                Button(onClick = {
                    when (state.number) {
                        0 -> navController.navigate(NavRoutes.OnBoarding1.route)
                        1 -> navController.navigate(NavRoutes.OnBoarding2.route)
                        2 -> navController.navigate(NavRoutes.OnBoarding3.route)
                        3 -> navController.navigate(NavRoutes.OnBoarding4.route)
                        4 -> navController.navigate(NavRoutes.LoginPage.route)
                    }
                },
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 40.dp)
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.startGradient),
                                    colorResource(R.color.endGradient)
                                )
                            ),
                            RoundedCornerShape(99.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(99.dp)) {
                    Text(text = "Начать",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontFamily = poppinsFont,
                        fontWeight = FontWeight(700))
                }
            }
        }
    }
}