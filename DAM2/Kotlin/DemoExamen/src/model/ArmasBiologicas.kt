package model

class ArmasBiologicas(
    id:Int, nombre:String, nivelPotencia:Int, nivelDanio:Int,var descripcion:String)
    :Armas(id, nombre, nivelPotencia, nivelDanio) {


}