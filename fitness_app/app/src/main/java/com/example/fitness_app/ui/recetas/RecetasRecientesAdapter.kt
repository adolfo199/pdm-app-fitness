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

class RecetasRecientesAdapter:
    RecyclerView.Adapter<RecetasRecientesAdapter.RecientesViewHolder>() {

    private var myRecetas = emptyList<Recetas>()

    inner class RecientesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var nombre: TextView = itemView.findViewById(R.id.nameRecetaReciente)
        var cantCalorias:TextView = itemView.findViewById(R.id.txtCantidadCalorias)
        var imagen: ImageView = itemView.findViewById(R.id.imageRecetaReciente)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecientesViewHolder {
        return RecientesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_receta_reciente, parent, false))
    }

    override fun onBindViewHolder(holder: RecientesViewHolder, position: Int) {
        holder.nombre.text = myRecetas[position].nombre
        holder.cantCalorias.text = myRecetas[position].calorias
        Picasso.get().load(myRecetas[position].image).into(holder.imagen)


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.imagen.context, RecetaActivity::class.java)
            intent.putExtra("receta", myRecetas[position])
            ContextCompat.startActivity(holder.imagen.context, intent, null)

        }


    }

    override fun getItemCount(): Int {
        return myRecetas.size
    }

    fun setData(newList: List<Recetas>){
        myRecetas = newList.reversed()
        notifyDataSetChanged()
    }
}