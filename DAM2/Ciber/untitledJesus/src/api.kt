import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import jdk.jfr.ContentType
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Saludo(val mensaje: String)

fun main() {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/saludo") {
                val saludo = Saludo("¡Hola! Este es un mensaje desde tu API en Kotlin.")
                val jsonString = "{\"mensaje\": \"${saludo.mensaje}\"}"
                call.respondText(jsonString, ContentType.Application.Json)
            }
        }
    }
    server.start(wait = true)
}