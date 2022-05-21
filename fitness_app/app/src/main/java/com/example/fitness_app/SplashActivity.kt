package com.example.fitness_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitness_app.ui.login.GetStartActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = Prefs(this)

        if (prefs.getIsLogin()){
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            startActivity(Intent(this, GetStartActivity::class.java))
        }


    }
}