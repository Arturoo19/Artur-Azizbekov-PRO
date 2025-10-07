package model

interface Sindicato {

    fun bajaSueldos(lista: ArrayList<Trabajador>):Boolean
    fun calcularBeneficios(): Double
}