import model.Categoria
import model.Cliente
import model.Tienda
import java.lang.ref.Cleaner

fun main() {

    var camiseta: Producto = Producto(id = 1, precio = 14.99, categoria = Categoria.Ropa)
    var zapatillas: Producto = Producto(2,20.0)
    var pantalones = Producto(3,30.0,"Pantalones")
    var gorra = Producto(4,20.0, descripcion = "Gorra molona")
    var cartera = Producto(5, 5.0, "Cartera", descripcion = "Catrera...")
    var telefono = Producto(6,200.00, nombre = "Samsung", descripcion = "movil")


    val listaProductos: Array<Producto?> = arrayOf(camiseta, zapatillas, pantalones, gorra, cartera, telefono)

    val listaClientes: Array<String> = arrayOf("asas","ada")

    val listaProductoVacio: Array<Producto?> = arrayOfNulls(5)




    /*listaProductos[0]?.mostrarDatos()
    listaProductos.last()?.precio=20.0
    listaProductos[listaProductos.size-1]?.mostrarDatos()
    listaProductos[2] = null


    /*for (i in listaProductos) {
        i?.mostrarDatos()
    }*/
    listaProductos.forEach { it?.mostrarDatos() }

    listaProductos.forEachIndexed{index , producto ->
        println("Mostrando producto en posicion $index")
        producto?.mostrarDatos()
    }*/

    var tienda:Tienda = Tienda("dda")
    tienda.almacen = listaProductos

    //tienda.agregarElemento(pantalones)
    //tienda.mostarDatosAlmacen()
    //tienda.buscarProductosCategoria(Categoria.Ropa)
    var cliente:Cliente = Cliente(1,"Artur")
    cliente.agregarProductoCarrito(gorra)
    cliente.mostrarCarrito()
    cliente.buscarProducto(0)




}
