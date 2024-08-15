package com.example.setlogger.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.setlogger.Adapters.WorkoutSelectionAdapter
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataset = arrayOf("Biceps", "Back", "Legs")

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = WorkoutSelectionAdapter(dataset) {
            run { findNavController() }
        }
    }

}