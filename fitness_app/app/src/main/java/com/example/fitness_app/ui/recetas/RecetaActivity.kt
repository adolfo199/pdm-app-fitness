package com.example.fitness_app.ui.recetas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R
import com.example.fitness_app.databinding.ActivityRecetaBinding

class RecetaActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecetaBinding

    private var recyclerViewIngredientes : RecyclerView? = null
    private var recyclerViewIngredientesAdapter : RecyclerViewIngredientesAdapter? = null

    private var recyclerViewInstrucciones : RecyclerView? = null
    private var recyclerViewInstruccionesAdapter : RecyclerViewInstruccionesAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecetaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receta = intent.getSerializableExtra("receta") as Recetas

        binding.imageRecetas.setImageResource(receta.image)
        binding.toolTitle.title = receta.nombre
        binding.temPreparacion.text = receta.temPreparacion
        binding.cantPorciones.text = receta.porcionces
        binding.cantCalorias.text = receta.calorias

        setIngredientes(receta.ingredientes)
        setInstrucciones(receta.instrucciones)

    }

    private fun setIngredientes(ingredientes: List<String>){
        recyclerViewIngredientes = binding.RecyclerViewIngredientes
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(binding.RecyclerViewIngredientes.context)
        recyclerViewIngredientes!!.layoutManager = layoutManager
        recyclerViewIngredientesAdapter = RecyclerViewIngredientesAdapter(binding.RecyclerViewIngredientes.context, ingredientes)
        recyclerViewIngredientes!!.adapter = recyclerViewIngredientesAdapter

    }
    private fun setInstrucciones(instrucciones: List<String>){
        recyclerViewInstrucciones = binding.RecyclerViewInstrucciones
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(binding.RecyclerViewInstrucciones.context)
        recyclerViewInstrucciones!!.layoutManager = layoutManager
        recyclerViewInstruccionesAdapter = RecyclerViewInstruccionesAdapter(binding.RecyclerViewInstrucciones.context, instrucciones)
        recyclerViewInstrucciones!!.adapter = recyclerViewInstruccionesAdapter

    }
}