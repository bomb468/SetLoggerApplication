package com.example.setlogger.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.setlogger.R


class WorkoutSelectionAdapter(private val dataSet: Array<String>, private val lambdaFunction: () -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class WorkoutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val workoutNameHolder : TextView = view.findViewById(R.id.workoutName)
        fun bind(text : String){
            workoutNameHolder.text=text
        }
    }

    class AddWorkoutViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val entireView : ConstraintLayout = view.findViewById(R.id.entire_view)
        fun setOnClick(lambdaFunction: () -> Unit) {
            entireView.setOnClickListener{
                lambdaFunction()
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        when(viewType){
            0 -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.text_row_item, viewGroup, false)
                return WorkoutViewHolder(view)
            }
            else ->{
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.add_workout_item, viewGroup, false)
                return AddWorkoutViewHolder(view)
            }
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if (viewHolder is WorkoutViewHolder) {
            viewHolder.bind(dataSet[position])
        }else if (viewHolder is AddWorkoutViewHolder){
            viewHolder.setOnClick(lambdaFunction)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position<dataSet.size) return 0
        return 1;
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size+1

}
