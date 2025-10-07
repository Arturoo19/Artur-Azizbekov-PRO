package model

abstract class Armas(var id:Int,var nombre:String,var nivelPotencia:Int,var nivelDanio:Int) {

    open fun mostrarDatos(){
        println("Id: $id")
        println("Nombre: $nombre")
        println("Nivel de potencia: $nivelPotencia")
        println("Nivel de daño: $nivelDanio")
    }

}