package com.example.fitness_app.ui.recetas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.R
import com.example.fitness_app.data.API.RecetasRepository
import com.example.fitness_app.databinding.RecetasFragmentBinding

class RecetasFragment : Fragment() {

    private var _binding: RecetasFragmentBinding? = null
    private lateinit var viewModel: RecetasViewModel

    private var recyclerViewCategorias : RecyclerView? = null
    private var recyclerViewCategoriasAdapter : RecyclerViewCategoriasAdapter? = null

    private val myAdapter by lazy { RecetasAdapter() }
    private val AdapterRecientes by lazy { RecetasRecientesAdapter() }



    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RecetasFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupRecyclerview()
        setupRecyclerviewRecientes()
        val repository = RecetasRepository()
        val viewModelFactory = RecetasViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RecetasViewModel::class.java)
        viewModel.getReceta()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
                response.body()?.let { AdapterRecientes.setData(it) }
                binding.containerRecetas.visibility = VISIBLE
                binding.shimmerRecetas.visibility = GONE
            }
            else{
                Toast.makeText(binding.recyclerViewRecetas.context, "Algo salio mal", Toast.LENGTH_SHORT).show()
            }
        } )



        val categorias : MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("Ensaladas", R.drawable.ensaladas))
        categorias.add(Categorias("Vegetarianas", R.drawable.lasana_vegetariana))
        categorias.add(Categorias("Postres", R.drawable.postres))
        categorias.add(Categorias("Carnes y aves", R.drawable.carnes))
        categorias.add(Categorias("Mariscos", R.drawable.mariscos))
        categorias.add(Categorias("Desayunos", R.drawable.desayunos))

        setCategorias(categorias)


        //(activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_recetas)




        return root
    }



    private fun setupRecyclerview() {
        binding.recyclerViewRecetas.adapter = myAdapter
        binding.recyclerViewRecetas.layoutManager = LinearLayoutManager(binding.recyclerViewRecetas.context,RecyclerView.HORIZONTAL, false)
    }

    private fun setupRecyclerviewRecientes() {
        binding.RecyclerViewFavoritas.adapter = AdapterRecientes
        binding.RecyclerViewFavoritas.layoutManager = LinearLayoutManager(binding.recyclerViewRecetas.context)
    }

    private fun setCategorias(categorias: List<Categorias>){
        recyclerViewCategorias = binding.recyclerViewCategorias
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(binding.recyclerViewRecetas.context, RecyclerView.HORIZONTAL, false)
        recyclerViewCategorias!!.layoutManager = layoutManager
        recyclerViewCategoriasAdapter = RecyclerViewCategoriasAdapter(binding.recyclerViewRecetas.context, categorias)
        recyclerViewCategorias!!.adapter = recyclerViewCategoriasAdapter
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }





}

