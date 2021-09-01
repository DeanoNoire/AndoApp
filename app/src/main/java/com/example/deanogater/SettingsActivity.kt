package com.example.deanogater

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val sharedPreferences = getSharedPreferences("PRIPOJENI", Context.MODE_PRIVATE)

        val hostnameEditText = findViewById<EditText>(R.id.hostnameSettingsEdit)
        hostnameEditText.setText(sharedPreferences.getString("Hostname",""), TextView.BufferType.EDITABLE)
        val zpravaEditText = findViewById<EditText>(R.id.zpravaSettingsEdit)
        zpravaEditText.setText(sharedPreferences.getString("Zprava",""), TextView.BufferType.EDITABLE)


        val saveSettingsButton = findViewById<Button>(R.id.saveSettingsButton)
        saveSettingsButton.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("Hostname", hostnameEditText.text.toString())
            editor.putString("Zprava", zpravaEditText.text.toString())
            editor.apply()
            finish()
            Toast.makeText(this,"Uloženo",Toast.LENGTH_SHORT).show()

            super.onBackPressed();

        }
    }
}