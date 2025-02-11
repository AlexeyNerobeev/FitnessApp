package com.example.fitnessapp.presentation.Registration.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.Registration.RegisterVM
import com.example.fitnessapp.feature_app.presentation.SuccessRegistartion.SuccessRegistrationVM
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevSuccessReg(){
    val n = rememberNavController()
    SuccessRegistration(n)
}

@Composable
fun SuccessRegistration(navController: NavController, vm: SuccessRegistrationVM = koinViewModel()) {
    val state = vm.state.value
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .background(Color.White)
            .padding(innerPadding)) {
            Image(painter = painterResource(R.drawable.s_reg_art),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 102.dp)
                    .padding(horizontal = 49.dp))
            Column(modifier = Modifier
                .padding(top = 44.dp)
                .padding(horizontal = 79.dp),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "Добро пожаловать, \n${state.name}",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = montserratBold,
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Center
                )
                Text(text = "Теперь все готово, давайте достигать ваших целей вместе с нами.",
                    color = colorResource(R.color.sRegText),
                    fontFamily = montserratRegular,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 5.dp)
               )
            }
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter){
                Button(onClick = {
                    navController.navigate(NavRoutes.Home.route)
                },
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                        .background(brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.startGradient),
                                colorResource(R.color.endGradient)
                            )
                        ),
                            shape = RoundedCornerShape(99.dp)),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Transparent
                    )) {
                    Text(text = "Перейти домой",
                        color = Color.White,
                        fontWeight = FontWeight(700),
                        fontSize = 16.sp,
                        fontFamily = montserratBold
                    )
                }
            }
        }
    }
}