package com.example.fitnessapp.feature_app.presentation.Notification

import androidx.compose.foundation.background
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
import com.example.fitnessapp.feature_app.presentation.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.common.CustomNotification
import com.example.fitnessapp.feature_app.presentation.common.TopAppBar
import com.example.fitnessapp.feature_app.domain.models.Notification
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PrevNotificationScreen(){
    NotificationScreen(rememberNavController())
}

@Composable
fun NotificationScreen(navController: NavController, vm: NotificationVM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(NotificationEvent.GetNotifications)
    val notificationsList: List<Notification> = state.notifications
    if(state.error.isNotEmpty()){
        ErrorAlertDialog(state.error) {
            vm.onEvent(NotificationEvent.ClearError)
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Column(modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth()) {
                TopAppBar(navController, "Уведомления", Color.Black)
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()) {
                    for(i in notificationsList){
                        item{
                            CustomNotification(i.image,
                                i.text,
                                i.created_at)
                        }
                    }
//                    items(notificationsList.size) {
//                        Notification(painterResource(R.drawable.lunch),
//                            "Время обеда",
//                            "1 мин. назад")
//                    }
                }
            }
        }
    }
}