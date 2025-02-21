package com.example.fitnessapp.feature_app.presentation.Home.components

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
fun getBarChartDataHome(
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
                    168, 227, 217
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
fun BarChartHome() {

    val maxRange = 5
    val barData = getBarChartDataHome(11, maxRange, BarChartType.VERTICAL, DataCategoryOptions())
    val yStepSize = 1

    val xAxisData = AxisData.Builder()
        .axisStepSize(1.dp)
        .steps(barData.size - 1)
        .startDrawPadding(31.dp)
        .build()
    val yAxisData = AxisData.Builder()
        .steps(yStepSize)
        .build()
    val barChartData = BarChartData(
        chartData = barData,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        barStyle = BarStyle(
            paddingBetweenBars = 5.dp,
            barWidth = 21.dp,
            cornerRadius = 10.dp
        ),
        showYAxis = false,
        showXAxis = false,
        backgroundColor = colorResource(R.color.tfColor)
    )
    BarChart(modifier = Modifier
        .height(81.dp)
        .clip(RectangleShape)
        .background(Color.Transparent, RectangleShape),
        barChartData = barChartData)
}