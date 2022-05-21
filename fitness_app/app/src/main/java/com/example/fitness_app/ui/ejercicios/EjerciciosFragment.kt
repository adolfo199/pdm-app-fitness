package com.example.fitness_app.ui.ejercicios

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.Prefs
import com.example.fitness_app.R
import com.example.fitness_app.data.database.AppDatabase
import com.example.fitness_app.data.entities.UserProfileEntity
import com.example.fitness_app.databinding.EjerciciosFragmentBinding
import com.example.fitness_app.databinding.RecetasFragmentBinding

class EjerciciosFragment : Fragment() {

    private var _binding: EjerciciosFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter: RutinasAdapter

    private lateinit var userProfiliveData: LiveData<UserProfileEntity>
    private lateinit var userData:UserProfileEntity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EjerciciosFragmentBinding.inflate(inflater, container , false)
        val root: View = binding.root



        setRutinas(Rutinas.rutinas)

        return root
    }

    override fun onStart() {
        super.onStart()
        data()
    }

    override fun onResume() {
        super.onResume()
        //data()
    }



    fun data(){
        val database = AppDatabase.getDatabase(binding.recyclerRutinas.context)
        val prefs = Prefs(binding.recyclerRutinas.context)

        if (prefs.getIsDataInsert()) {
            userProfiliveData = database.userProfile().get(prefs.getID())

            userProfiliveData.observe(viewLifecycleOwner, Observer {
                userData = it

                binding.cantEjercicios.text = prefs.getnej().toString()
                binding.nKcal.text = prefs.getkca().toString()
                binding.nMinutos.text = prefs.getmi().toString()

            })
        }else{
            binding.cantEjercicios.text = "0"
            binding.nKcal.text = "0"
            binding.nMinutos.text = "0"
        }
    }



    private fun setRutinas(rutinas: List<Rutina>){
        recyclerView = binding.recyclerRutinas
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(binding.recyclerRutinas.context)
        recyclerView.layoutManager = layoutManager
        adapter = RutinasAdapter(binding.recyclerRutinas.context, rutinas)
        recyclerView.adapter = adapter
    }


}