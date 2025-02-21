package com.example.fitnessapp.feature_app.presentation.ActivityTracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.model.Point
import co.yml.charts.ui.barchart.BarChart
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.barchart.models.BarChartType
import co.yml.charts.ui.barchart.models.BarData
import co.yml.charts.ui.barchart.models.BarStyle
import kotlin.random.Random

@Composable
fun getBarChartDataActivityTracker(
    listSize: Int,
    maxRange: Int,
    barChartType: BarChartType,
    dataCategoryOptions: DataCategoryOptions
): List<BarData> {
    val list = arrayListOf<BarData>()
    for (index in 0 until listSize) {
        val point = when (barChartType) {
            BarChartType.VERTICAL -> {
                Point(
                    index.toFloat(),
                    Random.nextFloat()
                )
            }

            BarChartType.HORIZONTAL -> {
                Point(
                    Random.nextFloat(),
                    index.toFloat()
                )
            }
        }

        list.add(
            BarData(
                point = point,
                color = Color(
                    131, 242, 165
                ),
                dataCategoryOptions = dataCategoryOptions,
                label = "Bar$index",
            )
        )
    }
    return list
}

@Composable
fun BarChartActivityTracker() {
    val maxRange = 5
    val barData = getBarChartDataActivityTracker(7, maxRange, BarChartType.VERTICAL, DataCategoryOptions())
    val yStepSize = 1
    val days = listOf("Пон", "Вто", "Сре", "Чет", "Пят", "Суб", "Вос")

    val xAxisData = AxisData.Builder()
        .axisStepSize(1.dp)
        .steps(barData.size - 1)
        .startDrawPadding(31.dp)
        .labelData {index -> days[index]}
        .build()
    val yAxisData = AxisData.Builder()
        .steps(yStepSize)
        .build()
    val barChartData = BarChartData(
        chartData = barData,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        barStyle = BarStyle(
            paddingBetweenBars = 20.dp,
            barWidth = 22.dp,
            cornerRadius = 10.dp
        ),
        showYAxis = false,
        showXAxis = true
    )
    BarChart(modifier = Modifier
        .height(200.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.Transparent, RoundedCornerShape(20.dp)),
        barChartData = barChartData
    )
}