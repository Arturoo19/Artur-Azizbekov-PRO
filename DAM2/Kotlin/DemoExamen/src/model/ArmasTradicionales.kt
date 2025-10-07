package model

class ArmasTradicionales(
    id:Int,
    nombre:String,
    nivelPotencia:Int,
    nivelDanio:Int,
    var peso:Double)
    :Armas(id, nombre, nivelPotencia, nivelDanio) {



}