package com.example.fitnessapp.feature_app.presentation.Notification

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.formatWithSkeleton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.fitnessapp.R
import com.example.fitnessapp.common.Notification
import com.example.fitnessapp.common.TopAppBar
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
                            Notification(i.image,
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