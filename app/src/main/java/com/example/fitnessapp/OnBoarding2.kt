package com.example.fitnessapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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

@Preview
@Composable
fun PrevOnBoarding2() {
    val n = rememberNavController()
    OnBoarding2(n)
}

@Composable
fun OnBoarding2(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(R.drawable.onb2_art),
                contentDescription = null,
                Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .padding(top = 64.dp)
                    .padding(horizontal = 30.dp)
            ) {
                Text(
                    text = "Сжигай лишнее",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = montserratBold
                )
                Text(
                    text = "Давайте продолжать заниматься, чтобы достичь своих целей, это больно только временно, если ты сдашься сейчас, тебе будет больно навсегда.",
                    color = colorResource(R.color.onBoardingText),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = montserratRegular,
                    modifier = Modifier
                        .padding(top = 15.dp)
                )
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                IconButton(
                    onClick = {
                        navController.navigate(NavRoutes.OnBoarding3.route)
                    },
                    modifier = Modifier
                        .padding(bottom = 45.dp)
                        .padding(end = 35.dp)
                        .size(60.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.startGradient),
                                    colorResource(R.color.endGradient)
                                )
                            ),
                            shape = CircleShape
                        ),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.arrow),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
}