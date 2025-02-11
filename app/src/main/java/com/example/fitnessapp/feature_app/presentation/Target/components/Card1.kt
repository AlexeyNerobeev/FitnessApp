package com.example.fitnessapp.presentation.Target

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessapp.R
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular

@Preview
@Composable
fun Card1() {
    Box(modifier = Modifier
        .width(275.dp)
        .height(478.dp)
        .background(brush = Brush.horizontalGradient(
            colors = listOf(
                colorResource(R.color.startGr),
                colorResource(R.color.endGr)
            )
        ), shape = RoundedCornerShape(22.dp)
        )){
        Column(modifier = Modifier
            .padding(top = 35.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(R.drawable.card1_art),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 46.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Text(text = "Улучшить форму",
                color = Color.White,
                fontWeight = FontWeight(600),
                fontSize = 14.sp,
                fontFamily = montserratRegular,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 25.dp)
            )
            Image(painter = painterResource(R.drawable.line),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 3.dp))
            Text(text = "У меня мало жира в организме, и мне нужно нарастить больше мышечной массы.",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                fontFamily = montserratRegular,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .padding(top = 20.dp)
                    .padding(bottom = 30.dp)
                    .fillMaxWidth()
            )
        }
    }
}