package com.example.fitness_app.ui.ejercicios

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.fitness_app.Prefs
import com.example.fitness_app.R
import com.example.fitness_app.data.database.AppDatabase
import com.example.fitness_app.data.entities.UserProfileEntity
import com.example.fitness_app.databinding.ActivityFinishBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.Observer
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinishBinding

    //adding media player
    private var player: MediaPlayer? = null
    private lateinit var userPrifileLiveData: LiveData<UserProfileEntity>
    private  var userData:UserProfileEntity? = null

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
        val prefs = Prefs(this)
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

        prefs.savenej(prefs.getnej()+ejercicios.ejercicios.size)
        prefs.savekca(prefs.getkca()+ejercicios.calorias)
        prefs.savemi(prefs.getmi()+ejercicios.duracion)

        val database = AppDatabase.getDatabase(this)


        userPrifileLiveData = database.userProfile().get(prefs.getID())

        userPrifileLiveData.observe(this, Observer {
            userData = it
            if (prefs.getIsDataInsert()){
                CoroutineScope(Dispatchers.IO).launch {
                    database.userProfile().update((userData!!.timeExercise + ejercicios.duracion), (userData!!.kcal+ejercicios.calorias), (userData!!.countExercise + ejercicios.ejercicios.size), prefs.getID())
                }


            }else{
                val userProfile = UserProfileEntity(0,0,0f,ejercicios.duracion,ejercicios.ejercicios.size,ejercicios.calorias,prefs.getID())
                CoroutineScope(Dispatchers.IO).launch {
                    database.userProfile().insertAll(userProfile)

                }
                prefs.saveIsDataInsert(true)
            }

        })










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
