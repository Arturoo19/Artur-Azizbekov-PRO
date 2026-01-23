import java.security.MessageDigest
import kotlin.system.exitProcess

fun main() {


    val hashObjetivo = "90857d2a9897cf1ebd88700cf8fd0e28377548676ae1eb2d7bdd9bf2b160b0e2"

    val alfabeto = "abcdefghijklmnopqrstuvwxyz0123456789"

    println("--- BUSCANDO HASH ---")
    println("Objetivo: $hashObjetivo")
    println("Alfabeto: $alfabeto")

    for (longitud in 1..6) {
        println("\n[INFO] Probando longitud: $longitud")
        romperHash("", longitud, alfabeto, hashObjetivo)
    }

    println("\n[-] No se encontró la contraseña.")
}

fun romperHash(
    prefijo: String,
    longitudRestante: Int,
    alfabeto: String,
    target: String
) {
    if (longitudRestante == 0) {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashIntento = digest.digest(prefijo.toByteArray())
            .joinToString("") { "%02x".format(it) }

        if (hashIntento.equals(target, ignoreCase = true)) {
            println("\n" + "=".repeat(40))
            println("[!] CONTRASEÑA ENCONTRADA")
            println("[!] Contraseña: $prefijo")
            println("=".repeat(40))
            exitProcess(0)
        }
        return
    }

    for (char in alfabeto) {
        romperHash(prefijo + char, longitudRestante - 1, alfabeto, target)
    }
}
