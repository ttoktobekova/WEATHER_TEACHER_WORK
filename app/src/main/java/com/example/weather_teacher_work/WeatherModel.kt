package com.example.weather_teacher_work

import java.io.Serializable


data class WeatherModel(
    val name: String,
    val main: MainModel,
    val weather: List<WeatherDescModel>

) : Serializable {
    override fun toString(): String {
        return "$name \n ${main.temp} \n ${main.humidity} \n ${main.feels_like} + \n ${weather.first().desc}  + \n ${weather.first().main}"
    }
}

data class WeatherDescModel(
    val main: String,
    val desc: String
) : Serializable

data class MainModel(
    val temp: Double,
    val feels_like: Double,
    val humidity: Int

) : Serializable






