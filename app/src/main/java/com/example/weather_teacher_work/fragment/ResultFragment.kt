package com.example.weather_teacher_work.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.weather_teacher_work.WeatherModel
import com.example.weather_teacher_work.databinding.FragmentResultBinding
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    val args: ResultFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertUnixToTime(unixTime: Long): String {
        val localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTime), ZoneId.systemDefault())
        val formatter = DateTimeFormatter.ofPattern("hh:mm a")
        return localDateTime.format(formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun init() {
        val weatherModel = args.argumentModel

        val cityName = weatherModel.name
        val temperature = weatherModel.main.temp
        val feelsLike = weatherModel.main.feels_like
        val humidity = weatherModel.main.humidity
        val sunrise = convertUnixToTime(weatherModel.sys.sunrise)
        val sunset = convertUnixToTime(weatherModel.sys.sunset)

        val weatherInfo =
            "Город: $cityName\nТемпература: $temperature\nОщущается как: $feelsLike\nВлажность: $humidity"
        binding.tvName.text = "Город ${cityName}"
        binding.tvTemp.text = "Температура ${temperature}"
        binding.tvHumidity.text = "Ощущается как ${humidity}"
        binding.tvFeelsLike.text = "Влажность ${feelsLike}"
        binding.tvSunrise.text = "Восход ${sunrise}"
        binding.tvSunset.text = "Закат ${sunset}"


//            binding.tvResult.text = weatherInfo
    }
}
