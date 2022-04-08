package com.example.fitness_app.ui.recetas

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R

class RecyclerViewIngredientesAdapter(private val context: Context, private val ingredientes: List<String>):
    RecyclerView.Adapter<RecyclerViewIngredientesAdapter.IngredientesViewHolder>() {

        class IngredientesViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

            var checkIngredientes:CheckBox? = null

            init {
                checkIngredientes = itemView.findViewById(R.id.textIngrediente)
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientesViewHolder {
        return IngredientesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_ingredientes, parent, false))
    }

    override fun onBindViewHolder(holder: IngredientesViewHolder, position: Int) {
        holder.checkIngredientes!!.text = ingredientes[position]
        holder.checkIngredientes!!.setOnClickListener {
            if (holder.checkIngredientes!!.isChecked){
                holder.checkIngredientes!!.setPaintFlags(holder.checkIngredientes!!.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            }else{
                holder.checkIngredientes!!.setPaintFlags(holder.checkIngredientes!!.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
            }
        }
    }

    override fun getItemCount(): Int {
        return ingredientes.size
    }
}