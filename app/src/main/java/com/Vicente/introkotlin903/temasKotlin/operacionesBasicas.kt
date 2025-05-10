package com.Vicente.introkotlin903.temasKotlin

fun main(){
    while(true) {
        println("Calculadora")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")

        print("Elige opcion: ")
        val opcion = readln().toInt()

        if(opcion == 5)break

        print("Primer numero: ")
        val num1 = readln().toDouble()

        print("Segundo numero: ")
        val num2 = readln().toDouble()


        val suma = num1 + num2

        val resta = num1 - num2

        val multiplicacion = num1 * num2

        val division = num1 / num2


        when(opcion) {
            1 -> println("Resultado de suma $suma ")
            2 -> println("Resultado de resta $resta")
            3 -> println("Resultado de multiplicacion $multiplicacion")
            4 -> println("Resultado de division $division")
            else -> println("Opción invalida")
        }
    }

    println("Programa finalizado")
}