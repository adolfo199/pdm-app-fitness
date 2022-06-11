package com.example.fitness_app.ui.recetas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fitness_app.data.API.RecetasRepository
import com.example.fitness_app.databinding.ActivityCategoriasBinding

class CategoriasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoriasBinding
    private lateinit var viewModel: RecetasViewModel
    private val myAdapter by lazy { CategoriasAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoria = intent.getSerializableExtra("categoria") as Categorias

        setupRecyclerview()
        val repository = RecetasRepository()
        val viewModelFactory = RecetasViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RecetasViewModel::class.java)
        viewModel.getReceta()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful){
                response.body()?.let { myAdapter.setData(it , categoria.nombre) }
            }
            else{
                Toast.makeText(this, "Algo salio mal", Toast.LENGTH_SHORT).show()
            }
        } )
        supportActionBar?.title = categoria.nombre

    }

   private fun setupRecyclerview() {
        binding.recetacategory.adapter = myAdapter
       binding.recetacategory.layoutManager = GridLayoutManager(this,2)
    }
}