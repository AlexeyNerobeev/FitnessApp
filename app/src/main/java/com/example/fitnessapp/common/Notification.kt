package com.example.fitnessapp.common

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessapp.R
import com.example.fitnessapp.presentation.WelcomeScreen.montserratRegular
import io.ktor.http.ContentType

@Preview
@Composable
fun PrevNotification(){
    Notification(painterResource(R.drawable.lunch), "Время обеда",
        "1 мин. назад")
}

@Composable
fun Notification(image: Painter, text: String, time: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 30.dp)
        .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically) {
        Image(painter = image,
            contentDescription = null
        )
        Column(modifier = Modifier
            .padding(start = 10.dp)) {
            Text(text = text,
                color = Color.Black,
                fontSize = 12.sp,
                fontFamily = montserratRegular,
                fontWeight = FontWeight(400)
            )
            Text(text = time,
                color = colorResource(R.color.notificationTime),
                fontWeight = FontWeight(400),
                fontFamily = montserratRegular,
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
            contentAlignment = Alignment.CenterEnd
        ){
            IconButton(onClick = {

            }) {
                Icon(painter = painterResource(R.drawable.notif_more),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 8.dp)
                )
            }
        }
    }
    Image(painter = painterResource(R.drawable.notif_line),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 15.dp)
    )
}