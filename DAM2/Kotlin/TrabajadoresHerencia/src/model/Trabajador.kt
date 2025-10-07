package model

abstract class Trabajador(
    nombre:String,apellido:String,dni:String, var salario:Double)
    : Persona(nombre,apellido, dni) {


    constructor(nombre: String,apellido: String,dni: String,salario: Double,telefono:Int,correo:String)
            :this(nombre, apellido, dni, salario){

        this.telefono = telefono
        this.correo = correo
    }




    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario: $salario")
        println("Telefono: $telefono")
    }
    abstract fun calcularSalarioNeto():Double;
}