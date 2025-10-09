package model

class Producto(var id: Int, var precio: Double=10.0,var nombre: String?=null, var descripcion: String?=null) {



    /*constructor(id: Int, precio: Double, descripcion: String?):this (id, precio){
        this.nombre = nombre
    }*/

    /*constructor(id: Int, precio: Double, nombre: String, descripcion:String?):this(id, precio) {
        this.nombre = nombre
        this.descripcion = descripcion
    }*/

    fun mostrarDatos(){
        println("Id=$id")
        println("Precio= $precio")
        println("Nombre= ${nombre ?: "Sin definir"}")
        println("Descripcion= ${descripcion ?: "Sin definir"}")

    }




}