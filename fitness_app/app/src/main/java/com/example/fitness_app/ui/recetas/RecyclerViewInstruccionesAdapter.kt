package com.example.fitness_app.ui.recetas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R

class RecyclerViewInstruccionesAdapter(private val context: Context, private val instrucciones: List<String>):
RecyclerView.Adapter<RecyclerViewInstruccionesAdapter.InstruccionesViewHolder>() {

    class InstruccionesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txtnumeroDePaso:TextView? = null
        var txtinstrucciones:TextView? = null

        init {
            txtnumeroDePaso = itemView.findViewById(R.id.numerodePaso)
            txtinstrucciones = itemView.findViewById(R.id.textInstrucciones)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstruccionesViewHolder {
        return InstruccionesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_instrucciones, parent, false))
    }

    override fun onBindViewHolder(holder: InstruccionesViewHolder, position: Int) {
        holder.txtnumeroDePaso!!.text = (position+1).toString()
        holder.txtinstrucciones!!.text = instrucciones[position]

    }

    override fun getItemCount(): Int {
        return instrucciones.size
    }
}