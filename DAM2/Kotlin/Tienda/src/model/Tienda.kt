package model

import Producto

class Tienda(var nombre: String) {
    var caja:Double =0.0
    lateinit var almacen: Array<Producto?>

    init {
        almacen = arrayOfNulls(6)
    }

    fun mostarDatosAlmacen(){
        var nulos = 0
        almacen.forEach {
            it?.mostrarDatos() ?: nulos++
        }
        if (nulos==almacen.size)
            println("No hay productos")
    }

    fun agregarElemento(producto: Producto){
        for (item in 0..almacen.size-1){
            if (almacen[item]==null){
                almacen[item] = producto
                println("Producto agregado")
                return
            }
        }
        println("No hay huecos")
    }
    fun venderProducto(id:Int){
        for (i in 0..almacen.size-1){

            if (almacen[i]!=null && almacen[i]?.id == id){
                caja+= almacen[i]!!.precio
                almacen[i] = null
                println("Producto vendido")
                return
            }
        }
        println("El id no esta en la lista")
    }
    fun buscarProductosCategoria(categoria: Categoria){
        val filtro: ArrayList<Producto?> = almacen.filter {
            return@filter it?.categoria == categoria
        } as ArrayList<Producto?>

        println("El numero de elementos resultantes es ${filtro.size}")
    }

    fun buscarProductoID(id: Int): Unit {
        var productoBusqueda: Producto? =  almacen.find {
            return@find it?.id == id
        }
    }

}