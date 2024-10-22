package com.example.setlogger.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.setlogger.MainActivity
import com.example.setlogger.adapters.WorkoutSelectionAdapter
import com.example.setlogger.R
import com.example.setlogger.databinding.FragmentWorkoutSelectionBinding
import com.example.setlogger.viewModels.WorkoutSelectionViewModel
import com.example.setlogger.viewModels.WorkoutSelectionViewModelFactory


class WorkoutSelectionFragment : Fragment() {

    private lateinit var binding: FragmentWorkoutSelectionBinding
    lateinit var workoutSelectionViewModel: WorkoutSelectionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = WorkoutSelectionViewModelFactory((activity as MainActivity).repository)
        workoutSelectionViewModel = ViewModelProvider(this,factory)[WorkoutSelectionViewModel::class.java]
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

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        // Initialize the adapter with an empty list
        val theAdapter = WorkoutSelectionAdapter(
            ArrayList(),{
                findNavController().navigate(R.id.action_workoutSelectionFragment_to_addWorkoutDialog)
            },{
                workoutName ->
                    findNavController().navigate(
                        WorkoutSelectionFragmentDirections.
                            actionWorkoutSelectionFragmentToWorkoutSetListFragment(workoutName)
                    )
            }
        )
        binding.recyclerView.adapter = theAdapter

        // Observe workoutNames from the ViewModel
        workoutSelectionViewModel.workoutNames.observe(viewLifecycleOwner) { value ->
            // Update the adapter with the new list
            theAdapter.updateWorkoutNames(value ?: emptyList<String>()) // Handle potential null case
        }
    }

    override fun onStart() {
        super.onStart()
        workoutSelectionViewModel.updateList((activity as MainActivity).repository)
    }

}