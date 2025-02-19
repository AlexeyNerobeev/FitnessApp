package com.example.fitnessapp.feature_app.presentation.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.common.BottomAppBar
import com.example.fitnessapp.common.TopAppBar
import com.example.fitnessapp.presentation.Registration.screens.montserratBold
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import com.example.fitnessapp.presentation.WelcomeScreen.poppinsFont
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevProfileScreen() {
    ProfileScreen(rememberNavController())
}

@Composable
fun ProfileScreen(navController: NavController, vm: ProfileVM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(ProfileEvent.GetProfile)
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
            ) {
                TopAppBar(navController, "Профиль", Color.Black)
                Column(
                    modifier = Modifier
                        .padding(top = 35.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.profile),
                            contentDescription = null
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 15.dp)
                        ) {
                            Text(
                                text = state.name,
                                color = Color.Black,
                                fontFamily = montserratBold,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500)
                            )
                            Text(
                                text = state.target,
                                color = colorResource(R.color.onBoardingText),
                                fontWeight = FontWeight(400),
                                fontFamily = montserratRegular,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                        }
                        Box(modifier = Modifier
                            .fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd){
                            Box(modifier = Modifier
                                .size(95.dp, 30.dp)
                                .background(Brush.horizontalGradient(
                                    colors = listOf(
                                        colorResource(R.color.startGradient),
                                        colorResource(R.color.endGradient)
                                    )
                                ),
                                    shape = RoundedCornerShape(99.dp))
                                .clickable {

                                },
                                contentAlignment = Alignment.Center
                            ){
                                Text(text = "Изменить",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontFamily = montserratRegular,
                                    fontWeight = FontWeight(500)
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxWidth()
                    ) {
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 10.dp
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .background(colorResource(R.color.shadowColor),
                                    RoundedCornerShape(16.dp)
                                ),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                                contentColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(16.dp),

                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(vertical = 11.dp)
                                    .padding(horizontal = 33.dp)
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "${state.height}",
                                    style = TextStyle(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGradient),
                                                colorResource(R.color.endGradient)
                                            )
                                        )
                                    ),
                                    fontFamily = poppinsFont,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500)
                                )
                                Text(
                                    text = "Рост",
                                    style = TextStyle(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGradient),
                                                colorResource(R.color.endGradient)
                                            )
                                        )
                                    ),
                                    fontFamily = poppinsFont,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400)
                                )
                            }
                        }
                        Spacer(modifier = Modifier
                            .width(15.dp))
                        ElevatedCard(
                            modifier = Modifier
                                .weight(1f)
                                .background(
                                    colorResource(R.color.shadowColor),
                                    RoundedCornerShape(16.dp)
                                ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 10.dp
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                                contentColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(vertical = 11.dp)
                                    .padding(horizontal = 33.dp)
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "${state.weight}",
                                    style = TextStyle(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGradient),
                                                colorResource(R.color.endGradient)
                                            )
                                        )
                                    ),
                                    fontFamily = poppinsFont,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500)
                                )
                                Text(
                                    text = "Вес",
                                    style = TextStyle(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGradient),
                                                colorResource(R.color.endGradient)
                                            )
                                        )
                                    ),
                                    fontFamily = poppinsFont,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400)
                                )
                            }
                        }
                        Spacer(modifier = Modifier
                            .width(15.dp))
                        ElevatedCard(
                            modifier = Modifier
                                .weight(1f)
                                .background(
                                    colorResource(R.color.shadowColor),
                                    RoundedCornerShape(16.dp)
                                ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 10.dp
                            ),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(
                                contentColor = Color.Transparent,
                                containerColor = Color.White
                            )
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(vertical = 11.dp)
                                    .padding(horizontal = 33.dp)
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "22",
                                    style = TextStyle(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGradient),
                                                colorResource(R.color.endGradient)
                                            )
                                        )
                                    ),
                                    fontFamily = poppinsFont,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500)
                                )
                                Text(
                                    text = "Лет",
                                    style = TextStyle(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.startGradient),
                                                colorResource(R.color.endGradient)
                                            )
                                        )
                                    ),
                                    fontFamily = poppinsFont,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400)
                                )
                            }
                        }
                    }
                    LazyColumn(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .fillMaxWidth()
                    ) {
                        item {
                            ElevatedCard(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        colorResource(R.color.shadowColor),
                                        RoundedCornerShape(16.dp)
                                    ),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 10.dp
                                ),
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Transparent
                                )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(vertical = 20.dp)
                                        .padding(start = 20.dp)
                                        .padding(end = 15.dp)
                                ) {
                                    Text(
                                        text = "Аккаунт",
                                        color = Color.Black,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(600),
                                        fontFamily = montserratBold
                                    )
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .clickable {  },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.account_data),
                                            contentDescription = null,
                                            tint = Color.Unspecified
                                        )
                                        Text(
                                            text = "Данные аккаунта",
                                            color = colorResource(R.color.onBoardingText),
                                            fontWeight = FontWeight(400),
                                            fontSize = 12.sp,
                                            fontFamily = poppinsFont,
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(painter = painterResource(R.drawable.arrow),
                                                contentDescription = null,
                                                tint = colorResource(R.color.onBoardingText)
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .clickable {  },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.achievement_icon),
                                            contentDescription = null,
                                            tint = Color.Unspecified
                                        )
                                        Text(
                                            text = "Достижения",
                                            color = colorResource(R.color.onBoardingText),
                                            fontWeight = FontWeight(400),
                                            fontSize = 12.sp,
                                            fontFamily = poppinsFont,
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(painter = painterResource(R.drawable.arrow),
                                                contentDescription = null,
                                                tint = colorResource(R.color.onBoardingText)
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .clickable {  },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.history_activity_icon),
                                            contentDescription = null,
                                            tint = Color.Unspecified
                                        )
                                        Text(
                                            text = "История активности",
                                            color = colorResource(R.color.onBoardingText),
                                            fontWeight = FontWeight(400),
                                            fontSize = 12.sp,
                                            fontFamily = poppinsFont,
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(painter = painterResource(R.drawable.arrow),
                                                contentDescription = null,
                                                tint = colorResource(R.color.onBoardingText)
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .clickable {  },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.workout_icon),
                                            contentDescription = null,
                                            tint = Color.Unspecified
                                        )
                                        Text(
                                            text = "Прогресс занятий",
                                            color = colorResource(R.color.onBoardingText),
                                            fontWeight = FontWeight(400),
                                            fontSize = 12.sp,
                                            fontFamily = poppinsFont,
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(painter = painterResource(R.drawable.arrow),
                                                contentDescription = null,
                                                tint = colorResource(R.color.onBoardingText)
                                            )
                                        }
                                    }
                                }
                            }
                            ElevatedCard(modifier = Modifier
                                .padding(top = 15.dp)
                                .background(
                                    colorResource(R.color.shadowColor),
                                    RoundedCornerShape(16.dp)
                                ),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 10.dp
                                ),
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Transparent
                                )
                            ){
                                Column(modifier = Modifier
                                    .padding(vertical = 20.dp)
                                    .padding(start = 20.dp)
                                    .padding(end = 15.dp)) {
                                    Text(
                                        text = "Уведомления",
                                        color = Color.Black,
                                        fontFamily = montserratBold,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(600)
                                    )
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .clickable { },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.switch_notif_icon),
                                            contentDescription = null,
                                            tint = Color.Unspecified
                                        )
                                        Text(
                                            text = "Уведомления",
                                            color = colorResource(R.color.onBoardingText),
                                            fontWeight = FontWeight(400),
                                            fontSize = 12.sp,
                                            fontFamily = poppinsFont,
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Switch(checked = state.check,
                                                onCheckedChange = {
                                                    vm.onEvent(ProfileEvent.ChangeCheck)
                                                },
                                                colors = SwitchDefaults.colors(
                                                    checkedTrackColor = colorResource(R.color.startGradient),
                                                    checkedThumbColor = Color.White,
                                                    uncheckedThumbColor = Color.White,
                                                    uncheckedTrackColor = Color.LightGray
                                                ),
                                                modifier = Modifier
                                                    .size(36.dp, 18.dp)
                                            )
                                        }
                                    }
                                }
                            }
                            ElevatedCard(modifier = Modifier
                                .padding(top = 15.dp)
                                .background(
                                    colorResource(R.color.shadowColor),
                                    RoundedCornerShape(16.dp)
                                ),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 10.dp
                                ),
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Transparent
                                )
                            ){
                                Column(modifier = Modifier
                                    .padding(vertical = 20.dp)
                                    .padding(start = 20.dp)
                                    .padding(end = 15.dp)) {
                                    Text(text = "Остальное",
                                        color = Color.Black,
                                        fontSize = 16.sp,
                                        fontFamily = poppinsFont,
                                        fontWeight = FontWeight(600)
                                    )
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .clickable {  },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.message_icon),
                                            contentDescription = null,
                                            tint = Color.Unspecified
                                        )
                                        Text(
                                            text = "Контакты",
                                            color = colorResource(R.color.onBoardingText),
                                            fontWeight = FontWeight(400),
                                            fontSize = 12.sp,
                                            fontFamily = poppinsFont,
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(painter = painterResource(R.drawable.arrow),
                                                contentDescription = null,
                                                tint = colorResource(R.color.onBoardingText)
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .clickable {  },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.privacy_icon),
                                            contentDescription = null,
                                            tint = Color.Unspecified
                                        )
                                        Text(
                                            text = "Политика кондефициальности",
                                            color = colorResource(R.color.onBoardingText),
                                            fontWeight = FontWeight(400),
                                            fontSize = 12.sp,
                                            fontFamily = poppinsFont,
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(painter = painterResource(R.drawable.arrow),
                                                contentDescription = null,
                                                tint = colorResource(R.color.onBoardingText)
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .clickable {  },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.settings_icon),
                                            contentDescription = null,
                                            tint = Color.Unspecified
                                        )
                                        Text(
                                            text = "Настройки",
                                            color = colorResource(R.color.onBoardingText),
                                            fontWeight = FontWeight(400),
                                            fontSize = 12.sp,
                                            fontFamily = poppinsFont,
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(painter = painterResource(R.drawable.arrow),
                                                contentDescription = null,
                                                tint = colorResource(R.color.onBoardingText)
                                            )
                                        }
                                    }
                                }
                            }
                            Box(modifier = Modifier
                                .height(100.dp))
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            BottomAppBar(navController, 4)
        }
    }
}