package com.example.fitness_app.ui.ejercicios

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.fitness_app.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class EjerciciosAdapter(private val context: Context, private val ejercicios:List<Ejercicio>) :
    RecyclerView.Adapter<EjerciciosAdapter.EjerciciosViewHolder>() {

        class EjerciciosViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
           val animacion:LottieAnimationView = itemView.findViewById(R.id.content)
           val namejercicio:TextView = itemView.findViewById(R.id.nameEjercicio)
            val repeticiones:TextView = itemview.findViewById(R.id.txtRepeticiones)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjerciciosViewHolder {
        return EjerciciosViewHolder(LayoutInflater.from(context).inflate(R.layout.item_ejercicio, parent , false))
    }

    override fun onBindViewHolder(holder: EjerciciosViewHolder, position: Int) {

        holder.namejercicio.text = ejercicios[position].nombre
        holder.repeticiones.text = ejercicios[position].repeticiones
        holder.animacion.setAnimation(ejercicios[position].anima)
        holder.animacion.playAnimation()
    }

    override fun getItemCount(): Int {
        return ejercicios.size
    }


}