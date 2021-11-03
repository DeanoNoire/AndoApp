package com.example.deanogater

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val sharedPreferences = getSharedPreferences("PRIPOJENI", Context.MODE_PRIVATE)


        garagePINEdit.setText(sharedPreferences.getString("GARAGEPIN",""), TextView.BufferType.EDITABLE)
        gatePINEdit.setText(sharedPreferences.getString("GATEPIN",""), TextView.BufferType.EDITABLE)


        val saveSettingsButton = findViewById<Button>(R.id.saveSettingsButton)
        saveSettingsButton.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("GARAGEPIN", garagePINEdit.text.toString())
            editor.putString("GATEPIN", gatePINEdit.text.toString())
            editor.apply()
            finish()
            Toast.makeText(this,"Uloženo",Toast.LENGTH_SHORT).show()

            super.onBackPressed()

        }
    }


}