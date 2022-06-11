package com.example.fitness_app.ui.ejercicios

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.databinding.ActivityRutinaBinding
import com.squareup.picasso.Picasso

class RutinaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRutinaBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EjerciciosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRutinaBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val ejercicios = intent.getSerializableExtra("ejercicios") as Rutina

        Picasso.get().load(ejercicios.image).into(binding.imageRutinas)
        binding.toolTitle2.title = ejercicios.name
        binding.minEjercicios.text = (ejercicios.duracion.toString()+" min · "+(ejercicios.ejercicios.size).toString()+ " ejercicios")

        setEjercicios(ejercicios.ejercicios)

        binding.btnInicio.setOnClickListener {
            finish()
            val intent = Intent(this@RutinaActivity, EjercicioActivity::class.java)
            intent.putExtra("ejercicios1", ejercicios)
            startActivity(intent)
        }
    }

    private fun setEjercicios(ejercicio: List<Ejercicio>){
        recyclerView = binding.recyclerEjercicios
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        recyclerView.layoutManager = layoutManager
        adapter = EjerciciosAdapter(this, ejercicio)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(decoration)
    }
}