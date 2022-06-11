package com.example.fitness_app.ui.ejercicios

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness_app.Prefs
import com.example.fitness_app.data.API.RutinasRepository
import com.example.fitness_app.data.database.AppDatabase
import com.example.fitness_app.data.entities.UserProfileEntity
import com.example.fitness_app.databinding.EjerciciosFragmentBinding

class EjerciciosFragment : Fragment() {

    private var _binding: EjerciciosFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: EjerciciosViewModel
    private val myAdapter by lazy { RutinasAdapter() }


    private lateinit var userProfiliveData: LiveData<UserProfileEntity>
    private lateinit var userData:UserProfileEntity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EjerciciosFragmentBinding.inflate(inflater, container , false)
        val root: View = binding.root

        if (isConnected(binding.recyclerRutinas.context)){
            setupRecyclerview()
            val repository = RutinasRepository()
            val viewModelFactory = EjerciciosViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(EjerciciosViewModel::class.java)
            viewModel.getRutinas()
            viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
                if (response.isSuccessful){
                    response.body()?.let { myAdapter.setData(it) }
                    binding.recyclerRutinas.visibility = VISIBLE
                    binding.shimmerRutinas.visibility = GONE
                }
                else{
                    Toast.makeText(binding.recyclerRutinas.context, "Algo salio mal", Toast.LENGTH_SHORT).show()
                }
            } )
        }
        else{
            Toast.makeText(binding.recyclerRutinas.context, "No tienes conexion a internet",Toast.LENGTH_LONG).show()
        }




        return root
    }

    private fun setupRecyclerview() {
        binding.recyclerRutinas.adapter = myAdapter
        binding.recyclerRutinas.layoutManager = LinearLayoutManager(binding.recyclerRutinas.context)
    }

    override fun onStart() {
        super.onStart()
        data()
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
    fun isConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }


}
