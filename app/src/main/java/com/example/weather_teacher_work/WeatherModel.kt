package com.example.weather_teacher_work

import java.io.Serializable


data class WeatherModel(
    val name: String,
    val main: MainModel,
    val sys : WeatherData
) : Serializable

data class WeatherData(
    val sunrise :Long,
    val sunset :Long
) :Serializable
data class MainModel(
    val temp: Double,
    val feels_like: Double,
    val humidity: Int

) : Serializable







