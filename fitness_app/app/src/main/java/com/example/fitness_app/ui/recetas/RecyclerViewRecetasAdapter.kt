package com.example.fitness_app.ui.recetas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R

class RecyclerViewRecetasAdapter(private val context: Context, private var recetas: List<Recetas>) :
    RecyclerView.Adapter<RecyclerViewRecetasAdapter.RecetasViewHolder>() {

    class RecetasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var nombreReceta : TextView? = null
        var imageReceta : ImageView? = null
        var imagefavorito : ImageView? = null
        var favorito:Boolean? = null


       init {
                nombreReceta = itemView.findViewById(R.id.nombreReceta)
                imageReceta = itemView.findViewById(R.id.imageReceta)
                imagefavorito = itemView.findViewById(R.id.imageFavorite)

       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetasViewHolder {
      return RecetasViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recetas, parent, false))
    }

    override fun onBindViewHolder(holder: RecetasViewHolder, position: Int) {
        holder.nombreReceta!!.text = recetas[position].nombre
        holder.imageReceta!!.setImageResource(recetas[position].image)

        if(recetas[position].favorita){
            holder.imagefavorito!!.setImageResource(R.drawable.ic_favorite_selected)
        }

        holder.imagefavorito!!.setOnClickListener {
            if (recetas[position].favorita){
                holder.imagefavorito!!.setImageResource(R.drawable.ic_favorite)
                holder.favorito = false
                recetas[position].favorita = holder.favorito!!
            }else{
                holder.imagefavorito!!.setImageResource(R.drawable.ic_favorite_selected)
                holder.favorito = true
                recetas[position].favorita = holder.favorito!!
            }

        }


    }

    override fun getItemCount(): Int {
        return recetas.size
    }
}