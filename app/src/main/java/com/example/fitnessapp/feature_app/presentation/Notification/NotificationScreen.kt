package com.example.fitnessapp.feature_app.presentation.Notification

import android.content.ClipData.Item
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.common.TopAppBar

@Preview
@Composable
fun PrevNotificationScreen(){
    NotificationScreen(rememberNavController())
}

@Composable
fun NotificationScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {
            Column(modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth()) {
                TopAppBar(navController, "Уведомления", Color.Black)
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()) {

                }
            }
        }
    }
}