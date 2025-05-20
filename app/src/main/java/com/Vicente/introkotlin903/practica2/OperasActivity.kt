package com.Vicente.introkotlin903.practica2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Vicente.introkotlin903.R
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class OperasActivity : AppCompatActivity() {
    private lateinit var edt1: EditText
    private lateinit var edt2: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var rbSumar: RadioButton
    private lateinit var rbRestar: RadioButton
    private lateinit var rbMultiplicar: RadioButton
    private lateinit var rbDividir: RadioButton
    private lateinit var btn1: Button
    private lateinit var tv1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operas)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        radioGroup = findViewById(R.id.radioGroup)
        rbSumar = findViewById(R.id.rbSumar)
        rbRestar = findViewById(R.id.rbRestar)
        rbMultiplicar = findViewById(R.id.rbMultiplicar)
        rbDividir = findViewById(R.id.rbDividir)
        btn1 = findViewById(R.id.btn1)
        tv1 = findViewById(R.id.tv1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun Calcular(view: View) {
        val valor1 = edt1.text.toString()
        val valor2 = edt2.text.toString()

        if (valor1.isEmpty() || valor2.isEmpty()) {
            Toast.makeText(this, "Debe ingresar ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val num1 = valor1.toDouble()
            val num2 = valor2.toDouble()
            var resultado = 0.0

            when {
                rbSumar.isChecked -> resultado = num1 + num2
                rbRestar.isChecked -> resultado = num1 - num2
                rbMultiplicar.isChecked -> resultado = num1 * num2
                rbDividir.isChecked -> {
                    if (num2 == 0.0) {
                        Toast.makeText(this, "No es posible dividir entre cero", Toast.LENGTH_SHORT).show()
                        return
                    }
                    resultado = num1 / num2
                }
            }

            tv1.text = "Resultado: $resultado"

        } catch (e: Exception) {
            Toast.makeText(this, "Error en los datos ingresados", Toast.LENGTH_SHORT).show()
        }
    }
}