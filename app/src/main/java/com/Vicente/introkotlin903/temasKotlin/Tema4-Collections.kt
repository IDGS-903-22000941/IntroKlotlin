package com.Vicente.introkotlin903.temasKotlin

fun main(){

    /*
    List = Val
    MutableList = Var
    Set
    MutableSet
    Map = no mutable
    MutableMap = mutable
     */


    var lista = listOf<String>("lunes", "martes", "miercoles")
    println(lista)
    println(lista.size)
    println(lista.get(0))
    println(lista[1])


    println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")


    println(lista.indexOf("miercoles"))
    println(lista.first())
    println(lista.last())


    println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")


    var listaMutable = mutableListOf<String>("lunes", "martes", "miercoles")
    println(listaMutable)
    listaMutable.add("jueves")
    println(listaMutable)
    listaMutable.removeAt(0)
    println(listaMutable)
    listaMutable.add(0, "domingo")
    println(listaMutable)
    listaMutable.remove("miercoles")
    println(listaMutable)




}