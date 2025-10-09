package model

class Jugador(
    var id:Int? = null,
    var nombre:String?=null,
    var posicion:String? = null,
    var valor:Int? = null,
    var puntos:Int? = null){

    fun mostrarDatos() {
        println("Id: $id")
        println("nombre: ${nombre}")
        println("Posicion: $posicion")
        println("Valor: $valor")
        println("Puntos: $puntos")
    }


}