package com.example.fitness_app.ui.recetas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R

class CategoriasAdapter(private val context: Context, private val recetas: List<Recetas>):
    RecyclerView.Adapter<CategoriasAdapter.CategoryViewHolder>(){

        class CategoryViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
            val image:ImageView = itemView.findViewById(R.id.imagecategory)
            val nombreReceta:TextView = itemView.findViewById(R.id.titleReceta)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
      return  CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_receta_mediun , parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
     // if(recetas[position].categoria == categoria){
          holder.image.setImageResource(recetas[position].image)
          holder.nombreReceta.text = recetas[position].nombre
     // }
    }

    override fun getItemCount(): Int {
      return  recetas.size
    }


}