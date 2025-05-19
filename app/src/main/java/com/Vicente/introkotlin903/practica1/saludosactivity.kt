package com.Vicente.introkotlin903.practica1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Vicente.introkotlin903.R

class saludosactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saludos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Añadir la funcionalidad al botón
        val button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button)
        val edtName = findViewById<androidx.appcompat.widget.AppCompatEditText>(R.id.edtName)

        button.setOnClickListener {
            val name = edtName.text.toString()
            if (name.isNotEmpty()) {
                Toast.makeText(this, "Hola $name!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, escribe tu nombre", Toast.LENGTH_SHORT).show()
            }
        }
    }
}