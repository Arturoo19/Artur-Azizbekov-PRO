import java.io.PrintWriter
import java.net.Socket
import java.net.UnknownHostException
import java.io.IOException

fun main() {
    val host = "192.168.2.101"
    val puertos = listOf(20, 21, 22, 80, 8080, 8000,12345)

    for (puerto in puertos) {
        try {
            val socket = Socket(host, puerto)
            println("Puerto $puerto está ABIERTO ✅")

            val out = PrintWriter(socket.getOutputStream(), true)
            out.println("Hola desde cliente en puerto $puerto!")

            socket.close()
        } catch (e: UnknownHostException) {
            println("Host desconocido: ${e.message}")
        } catch (e: IOException) {
            println("Puerto $puerto cerrado ❌")
        }
    }
}
