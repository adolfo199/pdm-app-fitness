package com.example.fitness_app.ui.recetas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R
import com.squareup.picasso.Picasso

class RecetasAdapter :
    RecyclerView.Adapter<RecetasAdapter.RecetasViewHolder>() {

    private var myRecetas = emptyList<Recetas>()

    inner class RecetasViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
         var nombre:TextView = itemView.findViewById(R.id.nombreReceta)
         var imagen:ImageView = itemView.findViewById(R.id.imageReceta)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetasViewHolder {
        return RecetasViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recetas, parent, false))
    }

    override fun onBindViewHolder(holder: RecetasViewHolder, position: Int) {
        holder.nombre.text = myRecetas[position].nombre
        Picasso.get().load(myRecetas[position].image).into(holder.imagen)


        holder.imagen.setOnClickListener {
            val intent = Intent(holder.imagen.context, RecetaActivity::class.java)
            intent.putExtra("receta", myRecetas[position])
            startActivity(holder.imagen.context, intent,null)

        }


    }

    override fun getItemCount(): Int {
        return myRecetas.size
    }

    fun setData(newList: List<Recetas>){
        myRecetas = newList
        notifyDataSetChanged()
    }
}