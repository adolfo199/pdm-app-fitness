package com.example.fitness_app.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.fitness_app.MainActivity
import com.example.fitness_app.Prefs
import com.example.fitness_app.R
import com.example.fitness_app.data.database.AppDatabase
import com.example.fitness_app.data.entities.UserEntity
import com.example.fitness_app.databinding.ActivityLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private lateinit var binding:ActivityLoginBinding
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtError.visibility = View.GONE


        val database = AppDatabase.getDatabase(this)


        binding.btnInicioSesion.setOnClickListener {
            val email = binding.edEmail.text.toString()
            val pass = binding.edPass.text.toString()

            if (binding.edEmail.text.toString() =="") {
                binding.edEmail.setError("Inserte su email")


            }
            else if (binding.edPass.text.toString() == ""){
                binding.edPass.setError("Inserte su contraseña")
            }else{
                val prefs = Prefs(this)
                try {
                    var login:Boolean = false
                    CoroutineScope(Dispatchers.IO).launch {
                        login = database.user().LoginUser(email, pass)
                        if (login) {
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            prefs.saveId(database.user().getId(email, pass))
                            this@LoginActivity.finish()

                        }
                    }
                    if (!login){
                        binding.txtError.visibility = View.VISIBLE
                    }
                }catch (e:Exception){

                }


            }
            binding.edEmail.setOnClickListener{
                binding.txtError.visibility = View.GONE
            }
            binding.edPass.setOnClickListener {
                binding.txtError.visibility = View.GONE
            }




        }
    }
}