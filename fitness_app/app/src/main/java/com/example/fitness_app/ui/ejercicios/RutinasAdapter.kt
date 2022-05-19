package com.example.fitness_app.ui.ejercicios

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R

class RutinasAdapter(private val context: Context, private val rutinas:List<Rutina>) :
    RecyclerView.Adapter<RutinasAdapter.RutinasViewHolder>() {

    class RutinasViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imageRutinas: ImageView? = null
        var nameRutina:TextView? = null

        init {
            imageRutinas = itemView.findViewById(R.id.imageRutina)
            nameRutina = itemView.findViewById(R.id.nombreRutina)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RutinasViewHolder {
        return RutinasViewHolder(LayoutInflater.from(context).inflate(R.layout.item_rutinas, parent, false))
    }

    override fun onBindViewHolder(holder: RutinasViewHolder, position: Int) {
        holder.nameRutina!!.text = rutinas[position].name
        holder.imageRutinas!!.setImageResource(rutinas[position].image)

        holder.imageRutinas!!.setOnClickListener {
            val intent = Intent(context, RutinaActivity::class.java)
            intent.putExtra("ejercicios", rutinas[position])
            startActivity(context, intent, null)
        }

    }

    override fun getItemCount(): Int {
        return  rutinas.size
    }
}