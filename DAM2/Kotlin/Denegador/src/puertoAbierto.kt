import java.net.ServerSocket

fun main() {
    val servidor = ServerSocket(1234)
    println("Servidor escuchando en puerto 1234...")

    while (true) {
        val cliente = servidor.accept()
        val mensaje = cliente.getInputStream().bufferedReader().readLine()
        println("Mensaje recibido: $mensaje")

        cliente.close()
    }
}
