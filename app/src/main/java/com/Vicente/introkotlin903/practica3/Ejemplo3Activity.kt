package com.Vicente.introkotlin903.practica3

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



class Ejemplo3Activity : AppCompatActivity() {

    private lateinit var tv1: TextView
    private lateinit var ed1: EditText
    private lateinit var button: Button
    private var num=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo3)
        ed1 = findViewById<EditText>(R.id.ed1)
        num=(Math.random()*100001).toInt()
        val cadena=num.toString()
        val notification=Toast.makeText(this,cadena,Toast.LENGTH_LONG)
        notification.show()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun controlar(view: android.view.View){
        val valorIngresado: String=ed1.text.toString()
        val valor=ed1.text.toString().toInt()
        if(valor==num) {
            val notification = Toast.makeText(this, "Adivinaste", Toast.LENGTH_LONG)
            notification.show()
        }else{
            val notification = Toast.makeText(this, "No adivinaste", Toast.LENGTH_LONG)
            notification.show()
        }
    }
}