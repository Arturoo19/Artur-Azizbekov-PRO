package model

import kotlin.random.Random

class Jefe(nombre:String,apellido:String,dni:String,salario:Double,var nivelresponsabilidad:Int):
    Trabajador(nombre, apellido, dni, salario),Sindicato {



    override fun calcularSalarioNeto(): Double {
        nivelresponsabilidad = Random.nextInt(1,6)
        if (nivelresponsabilidad>=3){
            salario *= 1.03

        } else{
            salario *=0.97
        }
        return salario
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Nivel responsabilidad: $nivelresponsabilidad")
    }

    override fun bajaSueldos(lista: ArrayList<Trabajador>): Boolean {
        println("Procedes a bajar los sueldos, eres jefe, puedes hacerlo parcialmente")
        lista.forEach {
            if (it !is Jefe){
                it.salario *=0.90
            }
        }
        return false
    }

    override fun calcularBeneficios(): Double {
        println("Como jefe, vas a colocar el beneficio de la empresa")
        return 0.0
    }
}