package com.example.weather_teacher_work.animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieDrawable
import com.example.weather_teacher_work.R
import com.example.weather_teacher_work.databinding.FragmentAnimationBinding

class AnimationFragment : Fragment() {
    private lateinit var binding: FragmentAnimationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimationBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnFullName.setOnClickListener {
                lottieView.setMinProgress(0.0f)
                lottieView.setMaxProgress(1.0f)
                lottieView.repeatCount = 0
                lottieView.repeatMode = LottieDrawable.RESTART
                lottieView.playAnimation()
            }
            btnStartDownload.setOnClickListener {
                lottieView.setMinProgress(0.0f)
                lottieView.setMaxProgress(0.59f)
                lottieView.repeatCount = LottieDrawable.INFINITE
                lottieView.repeatMode = LottieDrawable.REVERSE
                lottieView.playAnimation()
            }
            btnStopDownload.setOnClickListener {
                lottieView.setMinProgress(0.40f)
                lottieView.setMaxProgress(0.75f)
                lottieView.repeatCount = 0
                lottieView.repeatMode = LottieDrawable.RESTART
                lottieView.playAnimation()
            }
        }
    }

}