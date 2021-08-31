package com.example.deanogater

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SettingsActivity : AppCompatActivity() {

    private var PRAZDNY = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val sharedPreferences = getSharedPreferences("PRIPOJENI", Context.MODE_PRIVATE)

        val hostnameEditText = findViewById<EditText>(R.id.hostnameSettingsEdit)
        hostnameEditText.setText(sharedPreferences.getString("Hostname",""), TextView.BufferType.EDITABLE)
        val zpravaEditText = findViewById<EditText>(R.id.zpravaSettingsEdit)
        zpravaEditText.setText(sharedPreferences.getString("Zprava",""), TextView.BufferType.EDITABLE)

        val saveSettingsButton = findViewById<Button>(R.id.saveSettingsButton)

    }
}