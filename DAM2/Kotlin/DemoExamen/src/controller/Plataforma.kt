package controller

import model.*

class Plataforma {
    var listaSuperheroes = arrayListOf<Superheroes>()
    var listaArmas = arrayListOf<Armas>()

    fun crearSuperheroe(){
        println("Que tipo de superheroe quieres crear? 1.humano 2.mutante")
        val tipo = readln().toInt()
        println("id: ")
        val id = readln().toInt()
        println("nombre: ")
        val nombre = readln()
        println("nivel: ")
        val nivel = readln().toInt()
        when(tipo){
            1->{
                println("Resistencia: ")
                val resistencia = readln().toInt()

                println("Creando arma tradicional...")
                println("id: ")
                val idTradicional = readln().toInt()
                println("nombre: ")
                val nombreTradicional = readln()
                println("nivelPotencia: ")
                val nivelPotencia = readln().toInt()
                println("nivelDanio: ")
                val nivelDanio = readln().toInt()
                println("Peso: ")
                val peso = readln().toDouble()

                val armas = ArmasTradicionales(idTradicional,nombreTradicional,nivelPotencia,nivelDanio,peso)
                val humano = Humanos(id,nombre,nivel,resistencia,armas)
                listaSuperheroes.add(humano)
            }
            2->{}
        }
    }
    fun listaruperheroes(){
        listaSuperheroes.forEach {
            println(it)
        }
    }
    fun listarSuperheroes1(){
        if (listaSuperheroes.isEmpty()){
            println("lista esta vacia")
        } else{
            for (superheroe in listaSuperheroes){
                superheroe.mostrarDatos()
                println("Poder total: ${superheroe.calcularPoder()}")
            }
        }
    }
    fun listararmas(){
        for (armas in listaArmas){
            if (listaArmas.isEmpty()){
                println("lista esta vacia")
            } else{
                armas.mostrarDatos()
            }
        }
    }
    fun enfrentarSuperheroes(){
        if (listaSuperheroes.size<2){
            println("No hay suficientes superheroes..")
            return
        }
        println("itroduce el ID del superhero1")
        val id1 = readln().toInt()
        val superheroe1 = listaSuperheroes.find { it.id == id1 } ?: return println("No existe este id")

        println("Introduce id de superheroe2:")
        val id2 = readln().toInt()
        val superheroe2 = listaSuperheroes.find { it.id == id2 } ?: return println("No existe este id")

        val poder1 = superheroe1.calcularPoder()
        val poder2 = superheroe2.calcularPoder()

        when{
            poder1>poder2-> println("el ganador es ${superheroe1.nombre}")
            poder1<poder2-> println("el ganador es ${superheroe2.nombre}")
            else -> println("Es un empate")
        }

    }
}