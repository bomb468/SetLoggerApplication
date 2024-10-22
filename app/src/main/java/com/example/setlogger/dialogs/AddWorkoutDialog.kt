package com.example.setlogger.dialogs
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.setlogger.MainActivity
import com.example.setlogger.R
import com.example.setlogger.adapters.ImageSelectionAdapter
import com.example.setlogger.database.entities.RepUnits
import com.example.setlogger.database.entities.WorkoutDetails
import com.example.setlogger.databinding.AddWorkoutDialogBinding
import com.example.setlogger.fragments.WorkoutSetListFragment
import com.example.setlogger.repository.WorkoutDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddWorkoutDialog : DialogFragment() {

    private lateinit var binding: AddWorkoutDialogBinding

    private var indexOfColor=0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=AddWorkoutDialogBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val selectedName=binding.textInputEditText.text.toString()
            addWorkout(
                selectedName,
                (activity as MainActivity).repository
            )
            findNavController().navigate(
                AddWorkoutDialogDirections.actionAddWorkoutDialogToWorkoutSetListFragment(selectedName)
            )
        }

        /*val dataset = arrayOf("Red","Blue","Yellow","Pink","Purple","Cyan","Green")

        val gridLayoutManager=GridLayoutManager(activity,5)
        val adapter = ImageSelectionAdapter(dataset) { index ->
            run{
                indexOfColor=index
                Log.d("Display",indexOfColor.toString())
            }
        }

        binding.iconSelector.layoutManager = gridLayoutManager

        binding.iconSelector.adapter = adapter*/

    }
    fun addWorkout(workoutName : String, workoutDetailsRepository: WorkoutDetailsRepository){
        lifecycleScope.launch(Dispatchers.IO) {
            workoutDetailsRepository.insert(
                WorkoutDetails(0,workoutName,"Exercise 1",0, RepUnits.Kg,0)
            )
        }
    }

}