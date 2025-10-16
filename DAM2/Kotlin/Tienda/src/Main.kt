import model.Categoria
import model.Cliente
import model.Tienda
import java.lang.ref.Cleaner

fun main() {

    /*var camiseta: Producto = Producto(id = 1, precio = 14.99, categoria = Categoria.Ropa)
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

    var tienda:Tienda = Tienda("Tienda de Arturo")
    tienda.almacen = listaProductos

    //tienda.agregarElemento(pantalones)
    //tienda.mostarDatosAlmacen()
    //tienda.buscarProductosCategoria(Categoria.Ropa)
    var cliente:Cliente = Cliente(1,"Artur")
    cliente.agregarProductoCarrito(gorra)
    cliente.agregarProductoCarrito(gorra)
    cliente.agregarProductoCarrito(pantalones)
    cliente.mostrarCarrito()
    cliente.buscarProducto(0)*/

    var tienda:Tienda = Tienda("Tienda de Arturo")
    var cliente:Cliente = Cliente(1,"Artur")
    var opcion:Int =-1

    while (true){
        println(
            """
            ========== MENÚ PRINCIPAL ==========
            1. Agregar producto al almacén
            2. Mostrar productos del almacén
            3. Vender producto
            4. Buscar productos por categoría
            5. Buscar producto por ID
            6. Agregar producto al carrito
            7. Mostrar carrito
            8. Borrar producto del carrito
            9. Pedir factura
            0. Salir
            ===================================
        """)
        println("Eliga una opcion")


        when(readln().toIntOrNull()){
            1 ->{
                print("ID: "); val id = readln().toInt()
                print("Nombre: "); val nombre = readln()
                print("Precio: "); val precio = readln().toDouble()
                print("Descripción: "); val desc = readln()
                print("Categoría (Tecnologia, Muebles, Ropa, Generica): ")
                val categoria = Categoria.valueOf(readln())
                tienda.agregarElemento(Producto(id, precio, nombre, categoria,desc))
            }
            2 -> tienda.mostarDatosAlmacen()
            3 ->{
                println("Id del producto vender:")
                tienda.venderProducto(readln().toInt())
            }
            4 ->{
                print("Categoría (Tecnologia, Muebles, Ropa, Generica): ")
                val categoria = Categoria.valueOf(readln())
                tienda.buscarProductosCategoria(categoria)
            }
            5 -> {
                print("ID del producto a buscar: ")
                tienda.buscarProductoID(readln().toInt())
            }

            6 -> {
                print("ID del producto para agregar al carrito: ")
                val id = readln().toInt()
                val producto = tienda.almacen.find { it?.id == id }
                if (producto != null) {
                    cliente.agregarProductoCarrito(producto)
                } else {
                    println("Producto no encontrado.")
                }
            }

            7 -> cliente.mostrarCarrito()

            8 -> {
                print("ID del producto a borrar del carrito: ")
                cliente.borrarProductoDeCarrito(readln().toInt())
            }
            9 ->cliente.pedirfactura()
            0->{
                println("Hasta luego...")
                break
            }
            else -> println("Opcion no valida")
        }

    }
}
