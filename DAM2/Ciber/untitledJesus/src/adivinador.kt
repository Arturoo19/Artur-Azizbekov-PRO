import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val proceso = ProcessBuilder(
        "C:\\Users\\artur\\.jdks\\openjdk-23.0.2\\bin\\java.exe",
        "-cp",
        "C:\\GitHub\\Artur-Azizbekov-PRO\\DAM2\\Kotlin\\untitledJesus\\out\\production\\untitledJesus;" +
                "C:\\Users\\artur\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\2.1.0\\kotlin-stdlib-2.1.0.jar;" +
                "C:\\Users\\artur\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar",
        "DistribuidorKt"
    ).apply {
        redirectErrorStream(true)
    }

    val procesoArrancado = proceso.start()
    val out = OutputStreamWriter(procesoArrancado.outputStream)
    val input = BufferedReader(InputStreamReader(procesoArrancado.inputStream))

    var min = 1
    var max = 10
    var intento = (min + max) / 2

    
    println("Padre intenta: $intento")
    out.write("$intento\n")
    out.flush()

    while (true) {
        val linea = input.readLine() ?: break
        println("Hijo: $linea")

        if (linea == "adivinado") break

        // Ajustar rango según la pista
        if (linea == "mas") {
            min = intento + 1
        } else if (linea == "menos") {
            max = intento - 1
        }

        // Calcular nuevo intento con el rango actualizado
        intento = (min + max) / 2
        println("Padre intenta: $intento")

        out.write("$intento\n")
        out.flush()
    }
}
