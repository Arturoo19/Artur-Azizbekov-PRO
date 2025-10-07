package model

class Mutantes(id:Int,nombre:String,nivel:Int,var arma:ArmasBiologicas)
    :Superheroes(id, nombre, nivel) {

    override fun calcularPoder(): Int {
        return (nivel + (arma.nivelPotencia*arma.nivelDanio))
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Arma: ${arma.mostrarDatos()}")
    }

}