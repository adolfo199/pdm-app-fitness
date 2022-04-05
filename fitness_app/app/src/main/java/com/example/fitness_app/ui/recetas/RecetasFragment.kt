package com.example.fitness_app.ui.recetas

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness_app.MainActivity
import com.example.fitness_app.R
import com.example.fitness_app.databinding.RecetasFragmentBinding

class RecetasFragment : Fragment() {

    private var _binding: RecetasFragmentBinding? = null

    private var recyclerViewRecetas : RecyclerView? = null
    private var recyclerViewRecetasAdapter : RecyclerViewRecetasAdapter? = null

    private var recyclerViewCategorias : RecyclerView? = null
    private var recyclerViewCategoriasAdapter : RecyclerViewCategoriasAdapter? = null



    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val recetasViewModel =
            ViewModelProvider(this).get(RecetasViewModel::class.java)

        _binding = RecetasFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var recetas : MutableList<Recetas> = ArrayList()
        recetas.add(Recetas("Ensalada de huevo y aguacate", R.drawable.ensaladadehuevo,false))
        recetas.add(Recetas("lasana vegetariana", R.drawable.lasana_vegetariana,true))
        recetas.add(Recetas("Tarta de hojaldre con frutas", R.drawable.postre_tarta,true))
        recetas.add(Recetas("Pollo Glaseado con espinacas", R.drawable.pollo_glaseado,false))
        recetas.add(Recetas("Filetes de cerdo glaseados", R.drawable.filete_cerdo,false))
        recetas.add(Recetas("Fritata de chapinones", R.drawable.fritata_desayuno, false))
        recetas.add(Recetas("Ensalada de Camarones", R.drawable.ensalada_camarones, false))

        val categorias : MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("Ensaladas", R.drawable.ensaladadehuevo))
        categorias.add(Categorias("vegetarianas", R.drawable.lasana_vegetariana))
        categorias.add(Categorias("Postres", R.drawable.postre_tarta))
        categorias.add(Categorias("Carnes y aves", R.drawable.pollo_glaseado))
        categorias.add(Categorias("Mariscos", R.drawable.ensalada_camarones))
        categorias.add(Categorias("Desayunos", R.drawable.fritata_desayuno))
        setRecetas(recetas)
        setCategorias(categorias)


        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_recetas)



        recetasViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    private fun setRecetas(recetas: List<Recetas>){
        recyclerViewRecetas = binding.recyclerViewRecetas
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(binding.recyclerViewRecetas.context, RecyclerView.HORIZONTAL, false)
        recyclerViewRecetas!!.layoutManager = layoutManager
        recyclerViewRecetasAdapter = RecyclerViewRecetasAdapter(binding.recyclerViewRecetas.context, recetas)
        recyclerViewRecetas!!.adapter = recyclerViewRecetasAdapter

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