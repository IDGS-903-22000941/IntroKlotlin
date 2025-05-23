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
import com.Vicente.introkotlin903.cine.Cinepolis
import com.Vicente.introkotlin903.practica3.Ejemplo3Activity
import com.Vicente.introkotlin903.R
import com.Vicente.introkotlin903.practica4.archivosActivity

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

        val btnCinepolis = findViewById<Button>(R.id.button3)
        if (btnCinepolis == null) {
            Log.e(TAG, "onCreate: btnCinepolis (R.id.button3) not found!")
        } else {
            btnCinepolis.setOnClickListener {
                Log.d(TAG, "btnCinepolis clicked")
                navigateToCinepolis()
            }
        }

        val btnEjemplo3 = findViewById<Button>(R.id.button4)
        if (btnEjemplo3 == null) {
            Log.e(TAG, "onCreate: btnEjemplo3 (R.id.button4) not found!")
        } else {
            btnEjemplo3.setOnClickListener {
                Log.d(TAG, "btnEjemplo3 clicked")
                navigateToEjemplo3()
            }
        }

        val btnArchivos = findViewById<Button>(R.id.button5)
        if (btnArchivos == null) {
            Log.e(TAG, "onCreate: btnArchivos (R.id.button5) not found!")
        }else{
            btnArchivos.setOnClickListener {
                Log.d(TAG, "btnArchivos clicked")
                navigateToArchivos()
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


    private fun navigateToCinepolis() {
        Log.d(TAG, "navigateToCinepolis called")
        val intent = Intent(this, Cinepolis::class.java)
        startActivity(intent)
    }

    private fun navigateToEjemplo3() {
        Log.d(TAG, "navigateToEjemplo3 called")
        val intent = Intent(this, Ejemplo3Activity::class.java)
        startActivity(intent)
    }

    private fun navigateToArchivos() {
        Log.d(TAG, "navigateToArchivos called")
        val intent = Intent(this, archivosActivity::class.java)
        startActivity(intent)
    }

}