import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.random.Random

fun main() {
    val input = BufferedReader(InputStreamReader(System.`in`))
    val secreto = Random.nextInt(1, 11) // число від 1 до 10
    println("Adivina numero entre 1 y 10")

    while (true) {
        val intento = input.readLine()?.toIntOrNull() ?: continue

        when {
            intento < secreto -> println("mas")
            intento > secreto -> println("menos")
            else -> {
                println("adivinado")
                break
            }
        }
    }
}
