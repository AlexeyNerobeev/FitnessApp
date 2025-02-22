package com.example.fitnessapp.feature_app.presentation.WorkoutDetails2

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import co.yml.charts.ui.barchart.models.drawBarGraph
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.common.ErrorAlertDialog
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevWorkoutDetails2Screen(){
    WorkoutDetails2Screen(rememberNavController())
}

@Composable
fun WorkoutDetails2Screen(navController: NavController, vm: WorkoutDetails2VM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(WorkoutDetails2Event.GetExerciseData)
    if(state.error.isNotEmpty()){
        ErrorAlertDialog(state.error) {
            vm.onEvent(WorkoutDetails2Event.ClearError)
        }
    }
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Column(modifier = Modifier
                .padding(horizontal = 30.dp)) {
                Row(modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(painter = painterResource(R.drawable.close_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                    IconButton(onClick = {

                    }) {
                        Icon(painter = painterResource(R.drawable.details_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                }
                Image(painter = painterResource(R.drawable.video_section),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop)
                Text(text = state.name,
                    color = Color.Black,
                    fontFamily = montserratBold,
                    fontWeight = FontWeight(600),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
                Text(text = state.complexity,
                    color = colorResource(R.color.notificationTime),
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    fontFamily = montserratRegular,
                    modifier = Modifier
                        .padding(top = 5.dp)
               )
                Text(text = "Описание",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = montserratBold,
                    modifier = Modifier
                        .padding(top = 18.dp)
               )
                Text(text = state.description,
                    color = colorResource(R.color.notificationTime),
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    fontFamily = montserratRegular,
                    modifier = Modifier
                        .padding(top = 5.dp)
               )

            }
        }
    }
}