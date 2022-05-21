package com.example.fitness_app.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitness_app.MainActivity
import com.example.fitness_app.R
import com.example.fitness_app.databinding.ActivityGetStartBinding
import kotlin.system.exitProcess


private lateinit var binding:ActivityGetStartBinding
class GetStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEmpezar.setOnClickListener {
            startActivity(Intent(this, SigUpActivity::class.java))
        }
        binding.btnsesion.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}