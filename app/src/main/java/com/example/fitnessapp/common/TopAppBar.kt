package com.example.fitnessapp.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.presentation.Registration.screens.montserratBold

@Preview
@Composable
fun PrevTopAppBar(){
    TopAppBar(rememberNavController(), "fsfdsd", Color.White)
}

@Composable
fun TopAppBar(navController: NavController, activityName: String, titleColor: Color) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(painter = painterResource(R.drawable.back_icon),
                contentDescription = null,
                tint = Color.Unspecified)
        }
        Text(text = activityName,
            color = titleColor,
            fontSize = 16.sp,
            fontFamily = montserratBold,
            fontWeight = FontWeight(700)
        )
        IconButton(onClick = {

        }) {
            Icon(painter = painterResource(R.drawable.details_icon),
                contentDescription = null,
                tint = Color.Unspecified)
        }
    }
}