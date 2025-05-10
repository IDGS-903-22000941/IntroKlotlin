package com.Vicente.introkotlin903.temasKotlin

import kotlin.math.sqrt

fun main() {
    println("Practica de Formula General")

    var a = 1.0
    var b = 1.0
    var c = 1.0

    var seguirCalculando = true

    while (seguirCalculando) {
        println("\nIngrese los valores de la ecuacion ax^2 + bx + c = 0")

        println("Ingrese valor de a: ")
        a = readLine()!!.toDouble()

        while (a == 0.0) {
            println("El valor de a no puede ser 0. Ingrese otro valor: ")
            a = readLine()!!.toDouble()
        }

        println("Ingrese valor de b: ")
        b = readLine()!!.toDouble()

        println("Ingrese valor de c: ")
        c = readLine()!!.toDouble()

        val discriminante = b * b - 4 * a * c

        if (discriminante > 0) {
            val x1 = (-b + sqrt(discriminante)) / (2 * a)
            val x2 = (-b - sqrt(discriminante)) / (2 * a)

            println("La ecuacion tiene dos soluciones:")
            println("x1 = $x1")
            println("x2 = $x2")
        } else if (discriminante == 0.0) {
            val x = -b / (2 * a)

            println("La ecuacion tiene una solucion:")
            println("x = $x")
        } else {
            val parteReal = -b / (2 * a)
            val parteImaginaria = sqrt(-discriminante) / (2 * a)

            println("La ecuacion tiene soluciones complejas:")
            println("x1 = $parteReal + ${parteImaginaria}i")
            println("x2 = $parteReal - ${parteImaginaria}i")
        }

        println("\nQuieres hacer otro calculo? (s/n): ")
        val respuesta = readLine()!!

        if (respuesta != "s") {
            seguirCalculando = false
        }
    }

    println("Programa terminado.")
}