package com.example.weather_teacher_work

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: WeatherApi) {
    fun getWeather(city: String, liveData: MutableLiveData<WeatherModel>) {
        api.getWeather(city = city).enqueue(object : Callback<WeatherModel> {
            override fun onResponse(p0: Call<WeatherModel>, responce: Response<WeatherModel>) {
                if (responce.isSuccessful) {
                    responce.body()?.let { model ->
                        liveData.postValue(model)
                    }
                }
            }

            override fun onFailure(p0: Call<WeatherModel>, error: Throwable) {
                Log.e("ololo", "onFailure : ${error.message}")
            }

        })
    }
}