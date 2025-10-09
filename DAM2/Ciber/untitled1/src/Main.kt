import model.Producto


fun main() {
    var producto:Producto = Producto(1, 14.99)
    var zapatilla = Producto(2,16.00)
    var pantalones = Producto(3,30.0,"Pantalones")
    var gorra = Producto(4,210.0,"Cartera","Cartera para utilizar la pasta")

    val listaProductos:Array<Producto?> = arrayOf(zapatilla,pantalones,gorra)
    listaProductos.last()?.precio = 20.00
    listaProductos[2] = null
    for (i in listaProductos){
        i?.mostrarDatos()
    }


}