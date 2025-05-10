package com.Vicente.introkotlin903.temasKotlin

fun main(){

    /*
    practica3=impimir una piramide de * segun el numero dado por el usuario
    n=5
    *
    **
    ***
    ****
    *****
    cuando se capture un 0 terminar el programa, usar do while

     */



    var asteriscos = 1
    do {
        println("Agrega un numero para la piramide")
        asteriscos = readln().toInt()
        if (asteriscos > 0) {
            for (i in 1..asteriscos) {
                for (j in 1..i) {
                    print("*")
                }
                println()
            }
        }
    } while (asteriscos != 0)
println("Termino el programa")
    }