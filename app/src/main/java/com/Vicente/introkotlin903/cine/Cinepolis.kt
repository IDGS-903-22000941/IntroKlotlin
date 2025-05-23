package com.Vicente.introkotlin903.cine

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.Vicente.introkotlin903.R

class Cinepolis : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinepolis)

        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val editTextBoletos = findViewById<EditText>(R.id.editTextBoletos)
        val editTextCompradores = findViewById<EditText>(R.id.editTextCompradores)
        val checkBoxSi = findViewById<CheckBox>(R.id.checkBoxCinecoSi)
        val checkBoxNo = findViewById<CheckBox>(R.id.checkBoxCinecoNo)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultadoPrecio)
        val textViewDetalles = findViewById<TextView>(R.id.textViewDetalles)
        val botonCalcular = findViewById<Button>(R.id.buttonCalcular)
        val botonLimpiar = findViewById<Button>(R.id.buttonLimpiar)

        // Botón calcular - versión simple
        botonCalcular.setOnClickListener {
            // Obtener datos
            val nombre = editTextNombre.text.toString()
            val boletosTexto = editTextBoletos.text.toString()
            val compradoresTexto = editTextCompradores.text.toString()

            // Validar que no estén vacíos
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (boletosTexto.isEmpty()) {
                Toast.makeText(this, "Ingrese cantidad de boletos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (compradoresTexto.isEmpty()) {
                Toast.makeText(this, "Ingrese cantidad de compradores", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Convertir a números
            val boletos = boletosTexto.toInt()
            val compradores = compradoresTexto.toInt()

            // Validar números
            if (boletos <= 0) {
                Toast.makeText(this, "Debe comprar al menos 1 boleto", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (compradores <= 0) {
                Toast.makeText(this, "Debe haber al menos 1 comprador", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validar máximo 7 boletos por persona
            if (boletos > compradores * 7) {
                Toast.makeText(this, "Máximo 7 boletos por persona", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validar checkbox
            if (!checkBoxSi.isChecked && !checkBoxNo.isChecked) {
                Toast.makeText(this, "Seleccione si tiene tarjeta CINECO", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Calcular precio
            val precioBase = 12.0
            var total = boletos * precioBase
            var detalles = "Nombre: $nombre\n"
            detalles += "Boletos: $boletos\n"
            detalles += "Compradores: $compradores\n"
            detalles += "Precio inicial: $${total}\n\n"

            // Aplicar descuentos por cantidad
            if (boletos > 5) {
                val descuento = total * 0.15
                total = total - descuento
                detalles += "Descuento 15% (más de 5 boletos): -$${descuento}\n"
            } else if (boletos >= 3) {
                val descuento = total * 0.10
                total = total - descuento
                detalles += "Descuento 10% (3-5 boletos): -$${descuento}\n"
            }

            // Aplicar descuento por tarjeta CINECO
            if (checkBoxSi.isChecked) {
                val descuento = total * 0.10
                total = total - descuento
                detalles += "Descuento tarjeta CINECO 10%: -$${descuento}\n"
            }

            detalles += "\nTOTAL A PAGAR: $${total}"

            // Mostrar resultado
            textViewResultado.text = "$${total}"
            textViewDetalles.text = detalles

            Toast.makeText(this, "Cálculo completado", Toast.LENGTH_SHORT).show()
        }

        // Botón limpiar - versión simple
        botonLimpiar.setOnClickListener {
            editTextNombre.text.clear()
            editTextBoletos.text.clear()
            editTextCompradores.text.clear()
            checkBoxSi.isChecked = false
            checkBoxNo.isChecked = false
            textViewResultado.text = "$0.00"
            textViewDetalles.text = ""
            Toast.makeText(this, "Campos limpiados", Toast.LENGTH_SHORT).show()
        }
    }
}