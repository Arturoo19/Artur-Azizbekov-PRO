package model

class Autonomo(
    nombre:String,apellido:String,dni:String,salario:Double,var seguro:Boolean,var cuotas:Int):
    Trabajador(nombre, apellido, dni, salario) {

        override fun calcularSalarioNeto(): Double {
            return salario-(cuotas*12)
        }

    fun pedirDescuento(ppcent:Double){
        if (seguro){
            cuotas = (cuotas - cuotas*ppcent).toInt()
            println("Tu cuota ha dividido entre 2: $cuotas")
        } else{
            println("No tienes seguro")
        }
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("cuotas: ${cuotas}")
        println("seguro: ${seguro}")
    }

}