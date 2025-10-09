package controller

import model.Jugador
import model.Participante

class Fantasy {
    var listaJugadores = arrayListOf<Jugador>()
    var puntuaciones = arrayListOf<Jugador>()
    var ganador:Participante? = null
    var participantes:ArrayList<Participante> = arrayListOf()


    fun plantillaCompleta():Boolean{
        if (listaJugadores.size==6){
            return true
        }
        return false
    }
    fun agregarJugador(){
        if (listaJugadores.size<6){
            listaJugadores.add(Jugador(1,"Marc-André ter Stegen", "Portero",3000000))
            println("Jugador agregado")
        }else{
            println("Tienes plantilla completa")
        }
    }
    fun listarJugadores(){
        listaJugadores.forEach {
            if (it.valor!! >=3000000){
                println(it)
            }
        }
    }
    fun inicializarPuntos() {
        puntuaciones.add(Jugador(1, "Marc-André ter Stegen", puntos = 10))
        puntuaciones.add(Jugador(2, "Ronald Araújo", puntos = 0))
        puntuaciones.add(Jugador(3, "Eric García", puntos = 3))
        puntuaciones.add(Jugador(4, "Pedri", puntos = 23))
        puntuaciones.add(Jugador(5, "Robert Lewandowski", puntos = 15))
        puntuaciones.add(Jugador(6, "Courtois", puntos = 1))
        puntuaciones.add(Jugador(7, "David Alaba", puntos = 5))
        puntuaciones.add(Jugador(8, "Jesús Vallejo", puntos = 10))
        puntuaciones.add(Jugador(9, "Luka Modric", puntos = 5))
        puntuaciones.add(Jugador(10, "Karim Benzema", puntos = 10))
        puntuaciones.add(Jugador(11, "Ledesma", puntos = 6))
        puntuaciones.add(Jugador(12, "Juan Cala", puntos = 3))
        puntuaciones.add(Jugador(13, "Zaldua", puntos = 6))
        puntuaciones.add(Jugador(14, "Alez Fernández", puntos = 9))
        puntuaciones.add(Jugador(15, "Choco Lozano", puntos = 4))
        puntuaciones.add(Jugador(16, "Rajković", puntos = 3))
        puntuaciones.add(Jugador(17, "Raíllo", puntos = 6))
        puntuaciones.add(Jugador(18, "Maffeo", puntos = 0))
        puntuaciones.add(Jugador(19, "Ruiz de Galarreta", puntos = 7))
        puntuaciones.add(Jugador(25, "Ángel", puntos = 4))
        puntuaciones.add(Jugador(20, "Remiro", puntos = 3))
        puntuaciones.add(Jugador(21, "Elustondo", puntos = 5))
        puntuaciones.add(Jugador(22, "Zubeldia", puntos = 6))
        puntuaciones.add(Jugador(23, "Zubimendi", puntos = 7))
        puntuaciones.add(Jugador(24, "Take Kubo", puntos = 4))


    }

    fun iniciarJuego(){

    }

    fun agregarParticipante(participante: Participante){
        participantes.add(participante)
    }
    fun validarParticipante(): ArrayList<Participante> {
        // presupuesto>=0
        // 2 defensas
        // 2 medios
        // 1 delantero
        // 1 portero

        var participantesValidos = arrayListOf<Participante>()

        participantes.forEach {
            var nDefensas = 0
            var nPorteror = 0
            var nMedios = 0
            var nDelanteros = 0
            it.plantilla.forEach {
                if (it.posicion == "Portero")
                    nPorteror++
                if (it.posicion == "Defensa")
                    nDefensas++
                if (it.posicion == "Medio")
                    nMedios++
                if (it.posicion == "Delantero")
                    nDelanteros++
            }

            if (nPorteror == 1 && nDelanteros == 1 && nMedios == 2 && nDefensas == 2 && it.presupuesto > 0) {
                participantesValidos.add(it)
            }
        }
        return participantesValidos
    }
    fun iniciarConteo() {
        validarParticipante().forEach {
            it.plantilla.forEach { jugador ->
                it.puntos += puntuaciones.find { jugadorPuntuacion -> jugadorPuntuacion.nombre == jugador.nombre }?.puntos
                    ?: 0
            }
        }
    }
    fun obtenerJugadoresCaros(){
        listaJugadores.filter {
            return@filter it.valor!! > 3000000
        }.forEach{
            it.mostrarDatos()
        }
    }
}