package com.example.deanogater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.media.Image
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsButton = findViewById<ImageButton>(R.id.settingsButton)
        val garageStateText = findViewById<TextView>(R.id.GarageStatusText)


        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }




        GlobalScope.launch(){
            val garageStateString = zjistiStatus()
            changeGaragestate(garageStateString)
        }
        
        fun changeGarageState(input: String){
            garageStateText.text = input
        }


/*
        CoroutineScope(IO).launch {
            setTextOnMainThread()
        }
    }

    private suspend fun setTextOnMainThread(){
    withContext(Main){
       garageStateText.text = zjistiStatus()
    }
        */


    }

    private fun changeGaragestate(garageStateString: String) {

    }

    private suspend fun zjistiStatus() : String {
        delay(1000)
        //val url = "http://nightingales.clanweb.eu/pureStates.php"
        //val document = Jsoup.connect(url).get()
       //val status = document.select("#sgarage").first().text()
        val status = "PRDEL"
        println("Status "+status)
        return status
    }


}



