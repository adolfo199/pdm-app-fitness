package com.example.fitness_app.ui.ejercicios

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R
import com.example.fitness_app.databinding.EjerciciosFragmentBinding
import com.example.fitness_app.databinding.RecetasFragmentBinding

class EjerciciosFragment : Fragment() {

    private var _binding: EjerciciosFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter: RutinasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EjerciciosFragmentBinding.inflate(inflater, container , false)
        val root: View = binding.root

        setRutinas(Rutinas.rutinas)

        return root
    }



    private fun setRutinas(rutinas: List<Rutina>){
        recyclerView = binding.recyclerRutinas
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(binding.recyclerRutinas.context)
        recyclerView.layoutManager = layoutManager
        adapter = RutinasAdapter(binding.recyclerRutinas.context, rutinas)
        recyclerView.adapter = adapter
    }


}