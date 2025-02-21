package com.example.fitnessapp.feature_app.presentation.CongratulationPage

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular

@Preview
@Composable
fun PrevCongratulationPage(){
    CongratulationPage(rememberNavController())
}

@Composable
fun CongratulationPage(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Column(modifier = Modifier
                .padding(top = 65.dp)
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(painter = painterResource(R.drawable.congr_icon),
                    contentDescription = null)
                Text(text = "Поздравляем, вы\nзавершили тренировку",
                    color = Color.Black,
                    fontWeight = FontWeight(700),
                    fontFamily = montserratBold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 36.dp)
                )
                Text(text = "Упражнения – король, а питание – королева. Объедините их, и вы получите королевство.\n" +
                        "-Джек Лаланн",
                    color = colorResource(R.color.sRegText),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = montserratRegular,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 15.dp)
                )
            }
        }
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            Button(onClick = {
                navController.navigate(NavRoutes.Home.route)
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
                        shape = RoundedCornerShape(99.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Transparent
                )) {
                Text(text = "Завершить",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = montserratBold,
                    fontWeight = FontWeight(700)
                )
            }
        }
    }
}