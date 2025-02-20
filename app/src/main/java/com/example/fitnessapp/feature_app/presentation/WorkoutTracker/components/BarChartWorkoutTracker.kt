package com.example.fitnessapp.feature_app.presentation.WorkoutTracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.model.Point
import co.yml.charts.ui.barchart.BarChart
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.barchart.models.BarChartType
import co.yml.charts.ui.barchart.models.BarData
import co.yml.charts.ui.barchart.models.BarStyle
import com.example.fitnessapp.R
import kotlin.random.Random

@Composable
fun getBarChartDataWorkoutTracker(
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
                    "%.2f".format(Random.nextDouble(1.0, maxRange.toDouble())).toFloat()
                )
            }

            BarChartType.HORIZONTAL -> {
                Point(
                    "%.2f".format(Random.nextDouble(1.0, maxRange.toDouble())).toFloat(),
                    index.toFloat()
                )
            }
        }

        list.add(
            BarData(
                point = point,
                color = Color(
                    176, 248, 225
                ),
                dataCategoryOptions = dataCategoryOptions,
                label = "Bar$index",
            )
        )
    }
    return list
}

@Preview
@Composable
fun BarChartWorkoutTracker() {

    val maxRange = 5
    val barData = getBarChartDataWorkoutTracker(7, maxRange, BarChartType.VERTICAL, DataCategoryOptions())
    val yStepSize = 1
    val days = listOf("Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс")

    val xAxisData = AxisData.Builder()
        .axisStepSize(1.dp)
        .steps(barData.size - 1)
        .startDrawPadding(11.dp)
        .build()
    val yAxisData = AxisData.Builder()
        .steps(yStepSize)
        .labelData { index -> days[index] }
        .build()
    val barChartData = BarChartData(
        chartData = barData,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        barStyle = BarStyle(
            paddingBetweenBars = 22.dp,
            barWidth = 22.dp,
            cornerRadius = 10.dp
        ),
        showYAxis = true,
        showXAxis = true,
        backgroundColor = colorResource(R.color.startGradient)
    )
    BarChart(modifier = Modifier
        .height(172.dp)
        .clip(RectangleShape)
        .background(Color.Transparent, RectangleShape),
        barChartData = barChartData)
}