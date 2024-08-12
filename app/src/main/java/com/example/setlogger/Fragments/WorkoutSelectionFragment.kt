package com.example.setlogger.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.setlogger.R
import com.example.setlogger.databinding.FragmentSplashBinding
import com.example.setlogger.databinding.FragmentWorkoutSelectionBinding


class WorkoutSelectionFragment : Fragment() {


    private lateinit var binding: FragmentWorkoutSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentWorkoutSelectionBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

}