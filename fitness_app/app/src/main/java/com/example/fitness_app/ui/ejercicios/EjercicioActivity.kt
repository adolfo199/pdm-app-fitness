package com.example.fitness_app.ui.ejercicios

import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness_app.R
import com.example.fitness_app.databinding.ActivityEjercicioBinding
import java.util.*
import kotlin.collections.ArrayList

class EjercicioActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    //variable for rest timer
    private var restTimer: CountDownTimer?=null
    private var restProgress = 0// progress counts from 0 to 10

    //TO DO: change the restTimerDuration from 2 to 10 seconds after testing
    private var restTimerDuration: Long = 11

    //variable for exercise timer
    private var exerciseTimer: CountDownTimer?=null
    private var exerciseProgress = 0// progress from 0 to 30


    //TO DO: change the exerciseTimerDuration from 2 to 30 seconds after testing
    private var exerciseTimerDuration : Long = 31
    private var exerciseList: List<Ejercicio>?=null
    private var currentExercisePosition = -1

    //text to speech variable
    private var tts: TextToSpeech? = null

    //adding media player
    private var player: MediaPlayer? = null

    //creating exerciseAdapter for recyclerView
    private var exerciseAdapter: ExerciseStatusAdapter? = null

    private lateinit var binding: ActivityEjercicioBinding
    private lateinit var rutina: Rutina


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarEjercicio)
        val actionbar = supportActionBar
        if(actionbar != null){
            actionbar.setDisplayHomeAsUpEnabled(true)
        }

        //on clicking the back button a dialog box will pop up
        binding.toolbarEjercicio.setNavigationOnClickListener {
            customDialogForBackButton()
        }
        //adding text to speech feature
        tts = TextToSpeech(this,this)

        val ejercicios = intent.getSerializableExtra("ejercicios1") as Rutina
        exerciseList = ejercicios.ejercicios
        rutina = ejercicios
        setupRestView()

        setupExerciseStatusRecyclerView()
    }

    //onDestroy() is for resetting the timers and stop and shutdown the tts
    override fun onDestroy(){
        //resetting the restTimer
        if(restTimer != null){
            restTimer!!.cancel()
            restProgress = 0
        }
        //resetting the exerciseTimer
        if(exerciseTimer != null){
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }

        //destroying text to speech feature variable tts
        if(tts!=null){
            tts!!.stop()
            tts!!.shutdown()
        }
        //destroying media player
        if(player != null){
            player!!.stop()
        }
        //resetting the timer
        super.onDestroy()
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        customDialogForBackButton()
    }

    //This fun is for setting the rest timer for the user to get ready for upcoming exercise
    private fun setRestProgressBar(){
        binding.progressBar.progress = restProgress
        restTimer = object: CountDownTimer(restTimerDuration*1000, 1000){
            //onTick() is for countdown interval
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                binding.progressBar.progress = restTimerDuration.toInt() - restProgress
                binding.tvTimer.text = (restTimerDuration.toInt() - restProgress).toString()

                if ((restTimerDuration.toInt() - restProgress) <=3 && (restTimerDuration.toInt() - restProgress) >0){
                    speakOut((restTimerDuration.toInt() - restProgress).toString())
                }
            }

            //on finishing of the restTimer progressing the exercise timer
            override fun onFinish() {
                currentExercisePosition++

                //setting the current exercise to true
                exerciseList!![currentExercisePosition].isSelected = true
                exerciseAdapter!!.notifyDataSetChanged()

                //once the restTimer is over move to next Exercise screen
                setupExerciseView()
            }
        }.start()
    }

    //  This function is for starting ExerciseTimer after the user is ready to do exercise
    private fun setExerciseProgressBar(){
        binding.progressBarExercise.progress = exerciseProgress
        exerciseTimer = object: CountDownTimer(exerciseTimerDuration*1000, 1000){
            //onTick() is for the ExerciseTimer progress
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                binding.progressBarExercise.progress = exerciseTimerDuration.toInt() - exerciseProgress
                binding.tvExerciseTimer.text = (exerciseTimerDuration.toInt() - exerciseProgress).toString()

                if((exerciseTimerDuration.toInt() - exerciseProgress) <= 3 && (exerciseTimerDuration.toInt() - exerciseProgress) > 0){
                    speakOut((exerciseTimerDuration.toInt() - exerciseProgress).toString())
                }

                if((exerciseTimerDuration.toInt() - exerciseProgress) == 15){
                    speakOut("Vas por la mitad")
                }
                if((exerciseTimerDuration.toInt() - exerciseProgress) == 0){
                    player = MediaPlayer.create(applicationContext,R.raw.ding)
                    player!!.start()
                }
            }

            //on finishing a current exercise either move to next or to finish screen
            override fun onFinish() {
                if(currentExercisePosition < exerciseList?.size!! - 1){
                    //if all exercise performance is not completed
                    exerciseList!![currentExercisePosition].isSelected = false
                    exerciseList!![currentExercisePosition].isCompleted = true
                    exerciseAdapter!!.notifyDataSetChanged()
                    setupRestView()
                }else{
                    //  Call this when exercises activity is done and should be closed.
                    finish()
                    val intent = Intent(this@EjercicioActivity, FinishActivity::class.java)
                    intent.putExtra("ejercicios2", rutina)
                    startActivity(intent)

                }
            }
        }.start()
    }

    //setting up the Rest Screen for user to get ready
    private fun setupRestView(){
        try{
            //added the media player song
//            player = MediaPlayer.create(applicationContext,R.raw.background)
//            //preventing the media looping
//            player!!.isLooping = false //this will only play the song once
            // player!!.start()

        }catch (e: Exception){
            e.printStackTrace()
        }

        //making the exercise screen invisible nad rest screen visible
        binding.llRestView.visibility = View.VISIBLE
        binding.llExerciseView.visibility = View.GONE


        if(restTimer != null){
            //resetting the rest timer
            restTimer!!.cancel()
            restProgress = 0
        }

        binding.tvUpcomingExerciseName.text = exerciseList!![currentExercisePosition + 1].nombre
        speakOut("tómate un descanso, el siguiente 30 segundos,   "+exerciseList!![currentExercisePosition + 1].nombre)
        setRestProgressBar()
    }

    //setting the exercise screen
    private fun setupExerciseView(){

        //visibility use
        binding.llRestView.visibility = View.GONE
        binding.llExerciseView.visibility = View.VISIBLE


        if(exerciseTimer != null){
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }

        player = MediaPlayer.create(applicationContext,R.raw.silbato)
//            //preventing the media looping
//            player!!.isLooping = false //this will only play the song once
        player!!.start()

        //Function is used to speak the text ie current exercise name
        speakOut("Inicio. " + exerciseList!![currentExercisePosition].nombre)


        setExerciseProgressBar()

        //setting the exercise images and exercise name
        binding.ivImage.setAnimation(exerciseList!![currentExercisePosition].anima)
        binding.ivImage.playAnimation()
        binding.tvExerciseName.text = exerciseList!![currentExercisePosition].nombre
    }

    //   This is TextToSpeech override function
//    Called to signal the completion of the TextToSpeech engine initialization
    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            //setting the language to US English
            val result = tts!!.setLanguage(Locale.getDefault())

            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","Language specified is not supported")
                Toast.makeText(this,"Language not Supported",Toast.LENGTH_SHORT).show()
            }else{
                Log.e("TTS","Initialization Failed!")
            }
        }
    }


    //Function is used to speak the text ie current exercise name
    private fun speakOut(text: String){
        //ignore this error: It working fine after installing the app
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH,null,"")
    }

    private fun setupExerciseStatusRecyclerView(){
        binding.rvExerciseStatus.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        exerciseAdapter = ExerciseStatusAdapter(this, exerciseList!!)
        binding.rvExerciseStatus.adapter = exerciseAdapter
    }

    private fun customDialogForBackButton(){
        val customDialog = Dialog(this)

        customDialog.setContentView(R.layout.custom_dialog_for_exit)
        val tvYes:Button = customDialog.findViewById(R.id.tvYes)
        val tvNo:Button = customDialog.findViewById(R.id.tvNo)
        tvYes.setOnClickListener{
            finish()
            customDialog.dismiss()
        }

        tvNo.setOnClickListener{
            customDialog.dismiss()
        }
        customDialog.show()
    }
}