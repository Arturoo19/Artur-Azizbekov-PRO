package model

import kotlin.random.Random

class Asalariado(
    nombre:String,apellido:String,dni:String,salario:Double, var nPagas:Int,var irpf: Double):
    Trabajador(nombre,apellido,dni, salario) {






        override fun calcularSalarioNeto(): Double {
            return salario-(salario*irpf)
        }

        override fun mostrarDatos() {
            super.mostrarDatos()
            println("nPagas = $nPagas")
            println("irpf = $irpf")
        }

        fun pedirAumento(){
            var numAleatorio = Random.nextInt(1,11)
            if (numAleatorio<=5){
                println("Lo siento, no te vamos a subir el sueldo")
            } else{
                salario *= 1.1
            }
        }
    }