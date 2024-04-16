package com.example.weather_teacher_work.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.weather_teacher_work.WeatherModel
import com.example.weather_teacher_work.WeatherViewModel
import com.example.weather_teacher_work.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var weatherModel: WeatherModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        observer()
    }

    fun observer() {
        viewModel.weatherMutableLiveData.observe(viewLifecycleOwner) {
            binding.tvCity.text = it.name
            weatherModel = it


        }
    }

    fun initClickers() {
        (binding).apply {
            btnRequest.setOnClickListener {
                viewModel.getWeather(etCity.text.toString())
            }
            btnDetail.setOnClickListener {

                val action =
                    MainFragmentDirections.actionMainFragmentToResultFragment( weatherModel.toString())
                findNavController().navigate(action)
            }

        }
    }

}