package com.example.fitness_app.ui.login

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness_app.data.database.AppDatabase
import com.example.fitness_app.data.entities.UserEntity
import com.example.fitness_app.databinding.ActivitySigUpBinding
import com.example.fitness_app.ui.profile.ImageController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var binding: ActivitySigUpBinding
class SigUpActivity : AppCompatActivity() {
    private val SELECT_ACTIVITY = 50
    private var imageUri:Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = AppDatabase.getDatabase(this)

        binding.btnOk.setOnClickListener {
            val nombre = binding.edName.text.toString()
            val apellido = binding.edSurname.text.toString()
            val email = binding.edEmail2.text.toString()
            val pass = binding.edpass2.text.toString()

            if (binding.edName.text.toString().isEmpty()){
                binding.edName.setError("Ingresa tu nombre")
            }else if (binding.edSurname.text.toString().isEmpty()){
                binding.edSurname.setError("Ingresa tu apellido")
            }else if (binding.edEmail2.text.toString().isEmpty()){
                binding.edEmail2.setError("Ingresa tu Email")
            }else if (binding.edpass2.text.toString().isEmpty()){
                binding.edpass2.setError("ingrese una contraseña")
            }else{
                val user = UserEntity(email,pass,nombre, apellido)

                CoroutineScope(Dispatchers.IO).launch {
                 val id =  database.user().insertAll(user)[0]

                    imageUri?.let {
                        ImageController.saveImage(this@SigUpActivity, id, it)
                    }

                    startActivity(Intent(this@SigUpActivity, LoginActivity::class.java))
                    this@SigUpActivity.finish()
                }
            }


        }
        binding.imageView9.setOnClickListener {
            ImageController.selectPhotoFromGallery(this, SELECT_ACTIVITY)
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when{
            requestCode == SELECT_ACTIVITY && resultCode == Activity.RESULT_OK  ->{
                imageUri = data!!.data
                binding.imageView9.setImageURI(imageUri)
            }
        }
    }
}