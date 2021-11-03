package com.example.deanogater

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import org.jsoup.Jsoup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers.IO


class MainActivity : AppCompatActivity() {

    val MAIN_URL = "http://nightingales.clanweb.eu"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("PRIPOJENI", Context.MODE_PRIVATE)
        val garagePin = sharedPreferences.getString("GARAGEPIN", "")
        val gatePin = sharedPreferences.getString("GATEPIN", "")


        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        restartScrap.setOnClickListener {
            restartScrap.visibility = INVISIBLE
            mainCoroutine()
        }

        gateImage.setOnClickListener{
            println(gatePin)
            if (gatePin != null) {
                zmenStav(1, gatePin, this, MAIN_URL)
            }
        }

        garageImage.setOnClickListener{
            println(garagePin)
            if (garagePin != null) {
                zmenStav(2, garagePin, this, MAIN_URL)
            }
        }

        mainCoroutine()

    }

    private fun mainCoroutine() {
        CoroutineScope(IO).launch() {
            try {
                repeat(300) {
                    zjistiStatus()
                    delay(2000L)
                }
            } finally {
                println("Dojeto")
                zviditelniRestartScrap()
            }

        }
    }

    private suspend fun zviditelniRestartScrap(){
        withContext (Main) {
          restartScrap.visibility = VISIBLE
        }
    }

    private fun prepisTextView(statusGarage: String, statusGate: String){
        GarageStatusText.text = statusGarage
        GateStatusText.text = statusGate
    }

    private fun tickOnMain(procent: Int){
        tickerProgressBar.progress = procent
    }

    private fun gateImageSwapper(gateChange: Int, garageChange: Int,statusGate :String,statusGarage: String){
        if (gateChange == 1){
            val resName = "gat"+statusGate
            val idGate = resources.getIdentifier(resName, "drawable",packageName)
            println("$packageName $resName $idGate")
            gateImage.setImageResource(idGate)

        }

        if (garageChange == 1){
            val resName = "gar"+statusGarage
            val idGarage = resources.getIdentifier(resName, "drawable",packageName)
            println("$packageName $resName $idGarage")
            garageImage.setImageResource(idGarage)

        }
    }

    private fun checkChangeGarage(status: String): Int {
        val curr = GarageStatusText.text
        println("GARAGE: Current: $curr New:$status")
        return if(curr == status){
            0
        } else 1
    }

    private fun checkChangeGate(status: String): Int {
        val curr = GateStatusText.text
        println("GATE: Current: $curr New:$status")
        return if(curr == status){
            0
        } else 1
    }




    private suspend fun setTextOnMainThread(statusGarage: String, statusGate: String) {
        withContext (Main) {
            val gateChange = checkChangeGate(statusGate)
            val garageChange = checkChangeGarage(statusGarage)
            gateImageSwapper(gateChange,garageChange,statusGate,statusGarage)
            prepisTextView(statusGarage,statusGate)
            tick()
        }
    }

    private suspend fun zjistiStatus() {
       val url = "$MAIN_URL/pureStates.php"
       val document = Jsoup.connect(url).get()
       val statusGarage = document.select("#sgarage").first().text()
        val statusGate = document.select("#sgate").first().text()
        //  println("Status Garage $statusGarage Status Gate $statusGate")
        setTextOnMainThread(statusGarage,statusGate)
    }

    private suspend fun tick(){
        tickOnMain(100)
        delay(200L)
        tickOnMain(0)
    }



}



