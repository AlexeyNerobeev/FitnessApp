package com.example.fitnessapp.feature_app.presentation.Home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.example.fitnessapp.R

@Composable
fun PieChartHome() {
    val pieChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice("20.1",
                20.1f,
                colorResource(R.color.startGradient)
            ),
            PieChartData.Slice("",
                79.9f,
                Color.White)
        ),
        plotType = PlotType.Pie
    )
    val pieChartConfig = PieChartConfig(
        showSliceLabels = true,
        backgroundColor = colorResource(R.color.startGradient),
        labelVisible = false
    )
    PieChart(
        modifier = Modifier
            .padding(vertical = 29.dp)
            .size(88.dp)
            .clip(CircleShape)
            .background(Color.Transparent, CircleShape),
        pieChartData,
        pieChartConfig
    )
}