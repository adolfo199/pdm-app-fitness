package com.example.fitness_app.ui.ejercicios

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

class RutinasAdapter :
    RecyclerView.Adapter<RutinasAdapter.RutinasViewHolder>() {

    private var myRutinas = emptyList<Rutina>()

    inner class RutinasViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageRutinas:ImageView = itemView.findViewById(R.id.imageRutina)
        val nameRutina:TextView = itemView.findViewById(R.id.nombreRutina)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RutinasViewHolder {
        return RutinasViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rutinas, parent, false))
    }

    override fun onBindViewHolder(holder: RutinasViewHolder, position: Int) {
        holder.nameRutina.text = myRutinas[position].name
        Picasso.get().load(myRutinas[position].image).into(holder.imageRutinas)

        holder.imageRutinas.setOnClickListener {
            val intent = Intent(holder.imageRutinas.context, RutinaActivity::class.java)
            intent.putExtra("ejercicios", myRutinas[position])
            startActivity(holder.imageRutinas.context, intent, null)
        }

    }

    override fun getItemCount(): Int {
        return  myRutinas.size
    }
    fun setData(newList: List<Rutina>){
        myRutinas = newList
        notifyDataSetChanged()
    }
}