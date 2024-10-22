package com.example.setlogger.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.setlogger.R


class ImageSelectionAdapter(private val dataSet: Array<String>,private val lambdaFunction : (Int)->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder)
         */
        private var selectedPosition : Int = 0 // RecylerView.NO_POSITION
        class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val colorName : TextView = view.findViewById(R.id.color_name)
            val colorImage : ImageView = view.findViewById(R.id.color_image)
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
                if (position == selectedPosition) {
                    viewHolder.colorImage.background = ContextCompat.getDrawable(viewHolder.itemView.context, R.drawable.border_drawable)
                } else {
                    viewHolder.colorImage.background = ContextCompat.getDrawable(viewHolder.itemView.context, R.drawable.no_border)
                }
                viewHolder.bind(dataSet[position])
                viewHolder.colorImage.setOnClickListener {
                    notifyItemChanged(selectedPosition)
                    selectedPosition = viewHolder.adapterPosition
                    lambdaFunction(selectedPosition)
                    notifyItemChanged(selectedPosition)
                }
            }
        }
        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size
}
