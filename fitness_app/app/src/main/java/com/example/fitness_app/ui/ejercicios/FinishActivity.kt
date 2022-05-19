package com.example.fitness_app.ui.ejercicios

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fitness_app.R
import com.example.fitness_app.databinding.ActivityFinishBinding
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinishBinding

    //adding media player
    private var player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarfinish)
        val actionbar = supportActionBar //actionbar
        if(actionbar != null){
            actionbar.setDisplayHomeAsUpEnabled(true) //set back button
        }
        binding.toolbarfinish.title = "Fitness App"
        binding.toolbarfinish.setNavigationOnClickListener {
            onBackPressed()
        }

        val ejercicios = intent.getSerializableExtra("ejercicios2") as Rutina
        player = MediaPlayer.create(applicationContext,R.raw.success_sound)
         player!!.start()
        binding.Kcalorias.text = ejercicios.calorias.toString()
        binding.nEjercicios.text = ejercicios.ejercicios.size.toString()
        binding.duracion.text = ejercicios.duracion.toString()
        binding.confeti.setAnimation(R.raw.success)
        binding.confeti.playAnimation()
        binding.trofeo.setAnimation(R.raw.congratulations)
        binding.trofeo.playAnimation()



        //on finishing the workout calling the addDateToDatabase() to add the date and time in database
        addDateToDatabase()

    }

    //method for adding date to database and formatting the date format
    private fun addDateToDatabase(){
        val calendar = Calendar.getInstance()
        val dateTime = calendar.time
        Log.i("DATE:",""+dateTime)//making a log entry for testing

//        val sdf = SimpleDateFormat("dd-MMM-yyyy          HH:mm:ss", Locale.getDefault())//formatting date and time
        val sdf = SimpleDateFormat("dd-MMM-yyyy         HH:mm:ss aaa", Locale.getDefault())//formatting date and time
        val date = sdf.format(dateTime)

        //val dbHandler = SqliteOpenHelper(this,null)
       // dbHandler.addDate(date)
        Log.i("DATE: ", "Added")
    }



}
