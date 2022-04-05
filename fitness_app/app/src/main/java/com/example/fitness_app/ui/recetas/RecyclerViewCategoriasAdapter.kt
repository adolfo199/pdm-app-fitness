package com.example.fitness_app.ui.recetas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R

class RecyclerViewCategoriasAdapter(private val context: Context, private val categorias: List<Categorias>):
    RecyclerView.Adapter<RecyclerViewCategoriasAdapter.CategoriasViewHolder>(){


    class CategoriasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nombreCategoria : TextView? = null
        var imageCategorias : ImageView? = null

        init {
            nombreCategoria = itemView.findViewById(R.id.nombreCategoria)
            imageCategorias = itemView.findViewById(R.id.imageCategorias)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriasViewHolder {
        return CategoriasViewHolder(LayoutInflater.from(context).inflate(R.layout.item_categorias, parent, false))
    }

    override fun onBindViewHolder(holder: CategoriasViewHolder, position: Int) {
        holder.nombreCategoria!!.text = categorias[position].nombre
        holder.imageCategorias!!.setImageResource(categorias[position].image)
    }

    override fun getItemCount(): Int {
        return categorias.size
    }


}