@file:Suppress("DEPRECATION")

package com.example.fitnessapp.common

import androidx.compose.foundation.background
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun PrevErrorAlertDialog(){
    ErrorAlertDialog(""){}
}

@Composable
fun ErrorAlertDialog(ex: String,
                     click: () -> Unit) {
    AlertDialog(
        containerColor = Color.White,
        onDismissRequest = click,
        title = {
            Text(text = "Ошибка",
                color = Color.Black,
                fontSize = 20.sp)
        },
        text = {
            Text(text = ex,
                color = Color.Black,
                fontSize = 16.sp)
        },
        confirmButton = {
            Button(
                onClick = click
            ) {
                Text(text = "ОК",
                    color = Color.White,
                    fontSize = 14.sp)
            }
        }
    )
}