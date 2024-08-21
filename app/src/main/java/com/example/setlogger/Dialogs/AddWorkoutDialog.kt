package com.example.setlogger.Dialogs
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.example.setlogger.Adapters.ImageSelectionAdapter
import com.example.setlogger.databinding.AddWorkoutDialogBinding

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
        val dataset = arrayOf("Red","Blue","Yellow","Pink","Purple","Cyan","Green")

        val gridLayoutManager=GridLayoutManager(activity,5)
        val adapter = ImageSelectionAdapter(dataset) { index ->
            run{
                indexOfColor=index
                Log.d("Display",indexOfColor.toString())
            }
        }

        binding.iconSelector.layoutManager = gridLayoutManager

        binding.iconSelector.adapter = adapter

    }


}