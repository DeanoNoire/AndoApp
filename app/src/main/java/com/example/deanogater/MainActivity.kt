package com.example.deanogater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.media.Image
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsButton = findViewById<ImageButton>(R.id.settingsButton)

        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

    }

    fun zjistiStatus(){
        
    }
}