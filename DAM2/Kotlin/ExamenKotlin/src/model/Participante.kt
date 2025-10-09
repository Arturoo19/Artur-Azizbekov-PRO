package model

import controller.Fantasy

class Participante(var id:Int,
                   var nombre:String,
                   var presupuesto:Int = 10000000,var plantilla:ArrayList<Jugador> = arrayListOf() ){


    fun mostrarDatos() {
        println("Id: $id")
        println("Nombre: ${nombre}")
        println("Presupuesto: $presupuesto")
        println("Plantilla: $plantilla")
    }


}