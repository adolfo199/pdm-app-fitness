package com.example.fitness_app.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.fitness_app.MainActivity
import com.example.fitness_app.Prefs
import com.example.fitness_app.data.database.AppDatabase
import com.example.fitness_app.data.entities.UserEntity
import com.example.fitness_app.databinding.ActivityLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private lateinit var binding:ActivityLoginBinding
private lateinit var userLiveData: LiveData<UserEntity>
private lateinit var user: UserEntity
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtError.visibility = View.GONE


        val database = AppDatabase.getDatabase(this)
        var login = false
        var count = 0

        binding.btnInicioSesion.setOnClickListener {
            val email = binding.edEmail.text.toString()
            val pass = binding.edPass.text.toString()

            if (binding.edEmail.text.toString() =="") {
                binding.edEmail.error = "Inserte su email"


            }
            else if (binding.edPass.text.toString() == ""){
                binding.edPass.error = "Inserte su contraseña"
            }else{
                val prefs = Prefs(this)
                try {

                    userLiveData = database.user().LoginUser(email, pass)

                    userLiveData.observe(this, Observer {
                        if (it != null) {
                            user = it

                            if (user.email.equals(email) && user.password.equals(pass)){
                                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                                CoroutineScope(Dispatchers.IO).launch {
                                    prefs.saveId(database.user().getId(email, pass))
                                }
                                this@LoginActivity.finish()
                            }

                            }else{
                            binding.txtError.visibility = View.VISIBLE
                        }
                    })

//                    CoroutineScope(Dispatchers.IO).launch {
//                        login =
//                        if (login) {
//                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//                            prefs.saveId(database.user().getId(email, pass))
//                            this@LoginActivity.finish()
//
//                        }
//                    }
//                    if (!login){
//                        binding.txtError.visibility = View.VISIBLE
//                    }

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