package model

import controller.Fantasy

class Administrador(id:Int,nombre:String, var clave:Int)
    :Persona(id, nombre) {

    fun iniciarLiga(clave: Int, liga: Fantasy){
        if (clave == this.clave){
            liga.iniciarConteo()
        }
    }

}