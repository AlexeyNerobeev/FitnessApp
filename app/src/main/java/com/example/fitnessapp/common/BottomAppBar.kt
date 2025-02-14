package com.example.fitnessapp.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R

@Preview
@Composable
fun PrevBottomAppBar(){
    BottomAppBar(rememberNavController(), 0)
}

@Composable
fun BottomAppBar(navController: NavController, activityNumber: Int) {
    var homeIcon = painterResource(R.drawable.home_icon)
    var cameraIcon = painterResource(R.drawable.camera_icon)
    var profileIcon = painterResource(R.drawable.profile_icon)
    when(activityNumber){
        1 -> homeIcon = painterResource(R.drawable.home_active)
        3 -> cameraIcon = painterResource(R.drawable.camera_active)
        4 -> profileIcon = painterResource(R.drawable.profile_active)
    }
    Box(modifier = Modifier
        .height(90.dp)
        .fillMaxWidth()
        .background(Color.Transparent)
    ){
        Box(modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .background(Color.White)
        ){
            Row(modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth()
                .align(Alignment.Center),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.Top){
                    IconButton(
                        onClick = {
                            if (activityNumber != 1){
                                navController.navigate(NavRoutes.Home.route)
                            }
                        }
                    ) {
                        Icon(painter = homeIcon,
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                    IconButton(onClick = {
                        if(activityNumber != 2){

                        }
                    },
                        modifier = Modifier
                            .padding(start = 38.dp)) {
                        Icon(painter = painterResource(R.drawable.activity_icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                }
                Row(verticalAlignment = Alignment.Top){
                    IconButton(onClick = {

                    }) {
                        Icon(painter = cameraIcon,
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                    IconButton(onClick = {

                    },
                         modifier = Modifier
                             .padding(start = 38.dp)) {
                        Icon(painter = profileIcon,
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                }
            }
        }
        IconButton(onClick = {

        },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(60.dp)
                .background(brush = Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(R.color.startGradient),
                        colorResource(R.color.endGradient)
                    )
                ),
                    shape = CircleShape
                ),
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = Color.White,
                containerColor = Color.Transparent
            )) {
            Icon(painter = painterResource(R.drawable.search_icon),
                contentDescription = null,
                tint = Color.Unspecified)
        }
    }
}