package com.Vicente.introkotlin903.practica4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Vicente.introkotlin903.R
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.FileNotFoundException
import java.lang.Exception

class archivosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_archivos)

        val btnGuardar = findViewById<Button>(R.id.saveButton)
        val btnLeer = findViewById<Button>(R.id.readButton)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val outputText = findViewById<TextView>(R.id.outputText)
        val inputText = findViewById<EditText>(R.id.inputText)

        btnGuardar.setOnClickListener {
            val texto = inputText.text.toString()
            if (texto.isNotEmpty()) {
                try {
                    val archivo = openFileOutput("datos.txt", MODE_APPEND)
                    archivo.write((texto + "\n").toByteArray())
                    archivo.close() // Importante cerrar el archivo
                    Toast.makeText(this, "Texto guardado", Toast.LENGTH_SHORT).show()
                    inputText.text.clear() // Limpiar el campo de entrada
                } catch (e: Exception) {
                    Toast.makeText(this, "Error al guardar: ${e.message}", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            } else {
                Toast.makeText(this, "El texto está vacío", Toast.LENGTH_SHORT).show()
            }
        }

        btnLeer.setOnClickListener {
            try {
                val contenido = openFileInput("datos.txt").bufferedReader().useLines { lines ->
                    lines.joinToString("\n") // Corregido: usar paréntesis en lugar de llaves
                }
                outputText.text = contenido
            } catch (e: FileNotFoundException) {
                outputText.text = "Archivo no encontrado"
                Toast.makeText(this, "Archivo no encontrado", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                outputText.text = "Error al leer el archivo"
                Toast.makeText(this, "Error al leer: ${e.message}", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }

        btnBorrar.setOnClickListener {
            try {
                val file = File(filesDir, "datos.txt")
                if (file.exists()) {
                    file.delete()
                    outputText.text = ""
                    Toast.makeText(this, "Archivo borrado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "El archivo no existe", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error al borrar: ${e.message}", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}