package com.Vicente.introkotlin903

import android.content.Intent
import android.os.Bundle
import android.util.Log // Import Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Vicente.introkotlin903.practica1.saludosactivity
import com.Vicente.introkotlin903.practica2.OperasActivity

class MenuActivity : AppCompatActivity() {
    private val TAG = "MenuActivity" // Tag for logging

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        Log.d(TAG, "onCreate: Layout set to activity_menu")

        val btnSaludo = findViewById<Button>(R.id.button)
        if (btnSaludo == null) {
            Log.e(TAG, "onCreate: btnSaludo (R.id.button) not found!")
        } else {
            btnSaludo.setOnClickListener {
                Log.d(TAG, "btnSaludo clicked")
                navigateToSaludo()
            }
        }

        val btnOperas = findViewById<Button>(R.id.button2)
        if (btnOperas == null) {
            Log.e(TAG, "onCreate: btnOperas (R.id.button2) not found!")
        } else {
            btnOperas.setOnClickListener {
                Log.d(TAG, "btnOperas clicked")
                navigateToOperas()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigateToOperas() {
        Log.d(TAG, "navigateToOperas called")
        val intent = Intent(this, OperasActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludo() {
        Log.d(TAG, "navigateToSaludo called")
        val intent = Intent(this, saludosactivity::class.java)
        startActivity(intent)
    }
}