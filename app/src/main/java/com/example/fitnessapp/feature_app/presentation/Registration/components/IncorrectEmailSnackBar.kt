package com.example.fitnessapp.presentation.IncorrectEmailSnackBar

import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun IncorrectEmailSnackBar(message: String) {
    Snackbar{
        Text(message)
    }
}