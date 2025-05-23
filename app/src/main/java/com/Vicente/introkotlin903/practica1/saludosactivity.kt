package com.Vicente.introkotlin903.practica1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Vicente.introkotlin903.R
import android.content.Intent
import android.widget.EditText

class saludosactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saludos)

        val btnStart = findViewById<Button>(R.id.button)
        val edtName = findViewById<EditText>(R.id.edtName)

        btnStart.setOnClickListener {
            val name = edtName.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, resultado::class.java)
                intent.putExtra("name", name)  // Corregido: putExtra en lugar de put
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, escribe tu nombre", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}