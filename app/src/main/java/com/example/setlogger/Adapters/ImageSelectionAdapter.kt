package com.example.setlogger.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.setlogger.R

class ImageSelectionAdapter(private val dataSet: Array<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder)
         */
        class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val colorName : TextView = view.findViewById(R.id.color_name)
            fun bind(text : String){
                colorName.text=text
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.workout_image_item, parent, false)
            return CustomViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            if (viewHolder is CustomViewHolder){
                viewHolder.bind(dataSet[position])
            }
        }
        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size
}
