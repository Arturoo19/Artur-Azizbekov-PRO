package model

abstract class Persona(var nombre:String, var apellido:String,var dni:String) {
    var telefono:Int? = null
    var correo:String? = null


    constructor(nombre: String,apellido: String,dni: String,telefono:Int,correo:String):this(nombre,apellido, dni){
        this.telefono = telefono
        this.correo = correo
    }
    open fun mostrarDatos(){
        println("El nombre es $nombre")
        println("El apellido es $apellido")
        println("El dni es $dni")
        println("El telefono es ${telefono ?:"no se ha especificado"}")
        println("El correo es ${correo ?:"no se ha especificado"}")
    }

}