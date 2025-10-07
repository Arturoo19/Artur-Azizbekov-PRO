package model

class Directivo(nombre:String,apellido:String,dni:String,telefono:Int,correo:String, var nAcciones:Int)
    :Persona(nombre, apellido, dni,telefono, correo), Sindicato {
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nAcciones = $nAcciones")
    }

    fun venderAcciones(acciones:Int){
        if (acciones>nAcciones){
            println("No puedes vender tantas acciones")
        } else{
            nAcciones-= acciones
            println("Numero acciones actualizadas")
        }
    }


    override fun bajaSueldos(lista: ArrayList<Trabajador>): Boolean {
        println("Procedes a bajar los sueldos, eres directivo, puedes hacerlo parcialmente")
        lista.forEach {
            if (it is Jefe){
                it.salario = it.salario*0.90
            } else{
                it.salario = it.salario*0.80
            }

        }
        return true
    }

    override fun calcularBeneficios(): Double {
        println("Como directivo, vas a colocar el beneficio de la empresa")
        return 0.0
    }


}