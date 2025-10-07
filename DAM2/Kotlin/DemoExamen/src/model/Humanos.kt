package model

class Humanos(id:Int,nombre:String,nivel:Int,var resistencia:Int,var arma:ArmasTradicionales)
    :Superheroes(id, nombre, nivel) {

    override fun calcularPoder(): Int {
        return (nivel + (arma.nivelPotencia*arma.nivelDanio))
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("resistencia: $resistencia")
        println("Arma: ${arma.mostrarDatos()}")
    }


}