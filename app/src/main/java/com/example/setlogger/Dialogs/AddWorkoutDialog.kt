package com.example.setlogger.Dialogs
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.setlogger.Adapters.ImageSelectionAdapter
import com.example.setlogger.databinding.AddWorkoutDialogBinding

class AddWorkoutDialog : DialogFragment() {

    private lateinit var binding: AddWorkoutDialogBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=AddWorkoutDialogBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.iconSelector.layoutManager = GridLayoutManager(activity,5)
        val dataset = arrayOf("Red","Blue","Yellow","Pink","Purple","Cyan")
        binding.iconSelector.adapter = ImageSelectionAdapter(dataset)
    }


}