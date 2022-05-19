package com.example.fitness_app.ui.ejercicios

import android.content.Context
import android.graphics.Color
import android.graphics.Color.parseColor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R


/**
 * ExerciseStatusAdapter : Adapters provide a binding from an app-specific data set to views that are displayed
 * within a {@link RecyclerView}.
 *
 * Thus is a Adapter which is used to hold the Views of
 * Exercise status to be displayed in RecyclerView below the app.
 *
 * It represents the no completed, current, uncompleted exercises
 *
 */


class ExerciseStatusAdapter(val context: Context, val items:List<Ejercicio>) : RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {
//So the view Holder describes an item view and metadata about its place
// within the recycle of you.
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvItem = view.findViewById<TextView>(R.id.tvItem)
    }

    //onCreateViewHolder only creates a new view holder when there are
    // no existing view holders which the RecyclerView can reuse.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(
            R.layout.item_exercise_status,parent,false))
    }

    //Below function displays the no of exercise completed,
    // remaining content in recyclerView
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: Ejercicio = items[position]

        holder.tvItem.text = (position+1).toString()

        //changing the background color of completed,current,remaining exercises according to
        // conditions
        if(model.isSelected){
            //holder means for this current individual element
            holder.tvItem.background = ContextCompat.getDrawable(context,R.drawable.item_circular_color_accent_background)
            holder.tvItem.setTextColor(Color.parseColor("#212121"))
        }else if(model.isCompleted){
            holder.tvItem.background = ContextCompat.getDrawable(context,R.drawable.item_circular_blue_background_color)
            holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
        }else{
            holder.tvItem.background = ContextCompat.getDrawable(context,R.drawable.item_circular_gray_background)
            holder.tvItem.setTextColor(Color.parseColor("#212121"))
        }
    }

    //getItemCount() return the total number of exercise items.
    override fun getItemCount(): Int {
        return items.size
    }
}