package com.example.fitness_app.ui.recetas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R
import com.squareup.picasso.Picasso

class CategoriasAdapter:
    RecyclerView.Adapter<CategoriasAdapter.CategoryViewHolder>(){

       private var myRecetas = emptyList<Recetas>()
       private val receta = mutableListOf<Recetas>()
        class CategoryViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
            val image:ImageView = itemView.findViewById(R.id.imagecategory)
            val nombreReceta:TextView = itemView.findViewById(R.id.titleReceta)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
      return  CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_receta_mediun , parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
          holder.nombreReceta.text = myRecetas[position].nombre
          Picasso.get().load(myRecetas[position].image).into(holder.image)

        holder.image.setOnClickListener {
            val intent = Intent(holder.image.context, RecetaActivity::class.java)
            intent.putExtra("receta", myRecetas[position])
            ContextCompat.startActivity(holder.image.context, intent, null)

        }

    }

    override fun getItemCount(): Int {

      return  myRecetas.size
    }

    fun setData(newList: List<Recetas> , categoria:String){
        var index = 0
        while (index < newList.size){
           if (newList[index].categoria == categoria){
               receta.add(newList[index])
           }
            index++
        }
        myRecetas = receta
        notifyDataSetChanged()
    }


}