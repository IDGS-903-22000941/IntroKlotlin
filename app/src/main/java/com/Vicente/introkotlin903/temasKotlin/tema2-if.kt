package com.Vicente.introkotlin903.temasKotlin

fun main(){
    println("Ingrese el sueldo del empleado")
    val sueldo = readln().toDouble()
    if(sueldo > 3000){
        println("Ingrese el suelde del empleao")
    }else{
        println("No debe pagar impuestos")
    }

    //whwn

    val mes = 1

    when(mes){
        1 -> println("Enero")
        2 -> println("Febrero")
        3 -> println("Marzo")
        4 -> println("Abril")

        else -> println("Mes invalido")
    }





}