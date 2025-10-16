package model

import Producto

class Cliente(var id:Int, var nombre:String) {
    var factura: Double = 0.0
    lateinit var carrito: ArrayList<Producto>

    init {
        carrito = arrayListOf()
    }

    fun agregarProductoCarrito(producto: Producto){
        carrito.add(producto)
        println("Producto agregado al carrito")
    }

    fun mostrarCarrito(){
        if (carrito.isEmpty()){
            println("Carrito vacio")
        } else{
            carrito.forEach { it.mostrarDatos() }
        }
    }
    fun buscarProducto(posicion:Int){
        if (posicion>carrito.size-1){
            println("Id fuera del rango")
        }else{
            carrito[posicion].mostrarDatos()
        }
    }
    fun borrarProductoDeCarrito(idProducto: Int){
        val productoEliminar = carrito.filter {
            return@filter it.id == idProducto
        }
        println("el numero de resultados es ${productoEliminar.size}")


        if (productoEliminar.isEmpty()){
            println("no hay ninguno producto con este id")
        } else if (productoEliminar.size == 1){
            carrito.remove(productoEliminar.first())
            println("Producto borrado")
        } else{
            println("Se han encontrado varias coincidencias, "+
                    "1 para borrar primero/ n para borrar todos")
            val opcion:String = readln()
            if (opcion.equals("1",true)){
                carrito.remove(productoEliminar.first())
            } else  if (opcion.equals("n",true)){
                carrito.removeAll(productoEliminar.toSet())
            }
        }
    }

    fun pedirfactura(){
        if (carrito.isEmpty()){
            println("No hay productos en la lista")
        } else{
            carrito.forEach{
                factura+=it.precio
            }
            println("Debes un total de $factura")
            carrito.clear()
            factura = 0.0
        }
    }


}