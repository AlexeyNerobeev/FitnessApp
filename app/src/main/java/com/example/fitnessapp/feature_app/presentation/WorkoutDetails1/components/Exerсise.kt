package com.example.fitnessapp.feature_app.presentation.WorkoutDetails1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessapp.R
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular

@Preview
@Composable
fun PrevExerсise(){
    Exerсise(painter = painterResource(R.drawable.heart_icon), "asfa", "sfa")
}

@Composable
fun Exerсise(painter: Painter, name: String, repetitions: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 15.dp)
        .height(60.dp)
        .clickable {  },
        verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight(),
            contentScale = ContentScale.Crop)
        Column(modifier = Modifier
            .padding(start = 10.dp)) {
            Text(text = name,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                fontFamily = montserratRegular
            )
            Text(text = repetitions,
                color = colorResource(R.color.onBoardingText),
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                fontFamily = montserratRegular,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd){
            Icon(painter = painterResource(R.drawable.icon_next),
                contentDescription = null,
                tint = Color.Unspecified)
        }
    }
}