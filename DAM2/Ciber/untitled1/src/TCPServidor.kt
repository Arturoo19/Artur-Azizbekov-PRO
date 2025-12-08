import kotlinx.coroutines.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

@Serializable
data class LoginRequest(val user: String, val pass: String)

class TCPServidor {

    private val scope = CoroutineScope(Dispatchers.IO)

    fun iniciar() {
        scope.launch {
            val server = ServerSocket(6000)
            println("Servidor esperando clientes...")

            while (true) {
                val cliente = server.accept()
                println("Cliente conectado")

                launch {
                    val leer = BufferedReader(InputStreamReader(cliente.getInputStream()))
                    val escribir = PrintWriter(cliente.getOutputStream(), true)

                    val json = leer.readLine()
                    println("JSON recibido: $json")

                    val login = Json.decodeFromString<LoginRequest>(json)

                    // Aquí va la AUTH REAL
                    val valido = (login.user == "admin" && login.pass == "1234")

                    if (valido) {
                        escribir.println("OK: Login correcto")
                    } else {
                        escribir.println("ERROR: Usuario o contraseña incorrectos")
                    }

                    cliente.close()
                }
            }
        }
    }
}

fun main() {
    TCPServidor().iniciar()
}
