package com.example.fitnessapp.feature_app.presentation.ActivityTracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.common.TopAppBar
import com.example.fitnessapp.feature_app.presentation.ActivityTracker.components.BarChartActivityTracker
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import com.example.fitnessapp.presentation.WelcomeScreen.poppinsFont
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevActivityTrackerScreen() {
    ActivityTrackerScreen(rememberNavController())
}

@Composable
fun ActivityTrackerScreen(navController: NavController, vm: ActivityTrackerVM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(ActivityTrackerEvent.GetTodayTarget)
    if(state.error.isNotEmpty()){
        ErrorAlertDialog(state.error) {
            vm.onEvent(ActivityTrackerEvent.ClearError)
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(modifier = Modifier
                .padding(horizontal = 30.dp)) {
                TopAppBar(
                    navController, "Трекер активности",
                    Color.Black
                )
                LazyColumn(modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()) {
                    item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.startGradient),
                                    colorResource(R.color.endGradient)
                                )
                            ), shape = RoundedCornerShape(22.dp),
                            alpha = 0.2f
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .padding(horizontal = 20.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Сегодняшняя цель",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(600),
                                fontFamily = montserratBold
                            )
                            IconButton(onClick = {

                            }) {
                                Icon(
                                    painter = painterResource(R.drawable.add_today_target),
                                    contentDescription = null,
                                    tint = Color.Unspecified
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .padding(bottom = 20.dp)
                                .fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .background(
                                        Color.White,
                                        shape = RoundedCornerShape(12.dp)
                                    )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(start = 9.dp)
                                        .padding(top = 14.dp)
                                        .padding(bottom = 12.dp)
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.glass),
                                        contentDescription = null
                                    )
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 8.dp)
                                    ) {
                                        Text(
                                            text = "${state.water}Л",
                                            style = TextStyle(
                                                Brush.horizontalGradient(
                                                    colors = listOf(
                                                        colorResource(R.color.startGr),
                                                        colorResource(R.color.endGr)
                                                    )
                                                )
                                            ),
                                            fontWeight = FontWeight(500),
                                            fontSize = 14.sp,
                                            fontFamily = montserratRegular
                                        )
                                        Text(
                                            text = "Воды",
                                            color = colorResource(R.color.notificationTime),
                                            fontFamily = montserratRegular,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(400)
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier
                                .width(15.dp))
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .background(
                                        Color.White,
                                        shape = RoundedCornerShape(12.dp)
                                    )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(start = 9.dp)
                                        .padding(top = 14.dp)
                                        .padding(bottom = 12.dp)
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.boots),
                                        contentDescription = null
                                    )
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 8.dp)
                                    ) {
                                        Text(
                                            text = "${state.steps}",
                                            style = TextStyle(
                                                Brush.horizontalGradient(
                                                    colors = listOf(
                                                        colorResource(R.color.startGr),
                                                        colorResource(R.color.endGr)
                                                    )
                                                )
                                            ),
                                            fontWeight = FontWeight(500),
                                            fontSize = 14.sp,
                                            fontFamily = montserratRegular
                                        )
                                        Text(
                                            text = "Шагов",
                                            color = colorResource(R.color.notificationTime),
                                            fontFamily = montserratRegular,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(400)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Прогресс активности",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = montserratBold
                    )
                    Box(
                        modifier = Modifier
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        colorResource(R.color.startGradient),
                                        colorResource(R.color.endGradient)
                                    )
                                ),
                                shape = RoundedCornerShape(50.dp)
                            )
                            .size(76.dp, 30.dp)
                            .clickable {  },
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Неделя",
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = montserratRegular
                            )
                            Icon(
                                painter = painterResource(R.drawable.arrow_down),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .padding(start = 5.dp)
                            )
                        }
                    }
                }
                        Spacer(modifier = Modifier
                            .height(15.dp))
                        BarChartActivityTracker()
                Row(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Последняя активность",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = montserratBold
                    )
                    Text(text = "Больше",
                        color = colorResource(R.color.HomeWelcome),
                        fontFamily = montserratRegular,
                        fontWeight = FontWeight(500),
                        fontSize = 12.sp,
                        modifier = Modifier
                            .clickable {

                            }
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 15.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .background(
                                Color.White,
                                RoundedCornerShape(16.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(vertical = 15.dp)
                                .padding(horizontal = 15.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.last_activity1),
                                contentDescription = null
                            )
                            Column(
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .align(Alignment.CenterVertically)
                            ) {
                                Text(
                                    text = "Выпить 300мл воды",
                                    color = Color.Black,
                                    fontSize = 12.sp,
                                    fontFamily = montserratBold,
                                    fontWeight = FontWeight(500)
                                )
                                Text(
                                    text = "3 мин. назад",
                                    color = colorResource(R.color.lastActivity),
                                    fontWeight = FontWeight(400),
                                    fontSize = 10.sp,
                                    fontFamily = poppinsFont,
                                    modifier = Modifier
                                        .padding(top = 3.dp)
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                contentAlignment = Alignment.TopEnd
                            ) {
                                IconButton(
                                    onClick = {

                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.notif_more),
                                        contentDescription = null,
                                        tint = Color.Unspecified
                                    )
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .background(
                                Color.White,
                                RoundedCornerShape(16.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(vertical = 15.dp)
                                .padding(horizontal = 15.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.last_activity2),
                                contentDescription = null
                            )
                            Column(
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .align(Alignment.CenterVertically)
                            ) {
                                Text(
                                    text = "Скушать снек",
                                    color = Color.Black,
                                    fontSize = 12.sp,
                                    fontFamily = montserratBold,
                                    fontWeight = FontWeight(500)
                                )
                                Text(
                                    text = "10 мин. назад",
                                    color = colorResource(R.color.lastActivity),
                                    fontWeight = FontWeight(400),
                                    fontSize = 10.sp,
                                    fontFamily = poppinsFont,
                                    modifier = Modifier
                                        .padding(top = 3.dp)
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                contentAlignment = Alignment.TopEnd
                            ) {
                                IconButton(
                                    onClick = {

                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.notif_more),
                                        contentDescription = null,
                                        tint = Color.Unspecified
                                    )
                                }
                            }
                        }
                    }
                }
                    }
                }
            }
        }
    }
}