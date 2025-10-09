import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter

fun main() {
    val proceso = ProcessBuilder(
        "C:\\Users\\artur\\.jdks\\openjdk-23.0.2\\bin\\java.exe",
        "-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2024.3.2.2\\lib\\idea_rt.jar=53501:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2024.3.2.2\\bin",
        "-Dfile.encoding=UTF-8",
        "-Dsun.stdout.encoding=UTF-8",
        "-Dsun.stderr.encoding=UTF-8",
        "-cp",
        "C:\\GitHub\\Artur-Azizbekov-PRO\\DAM2\\untitled\\out\\production\\untitled;" +
                "C:\\Users\\artur\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\2.1.0\\kotlin-stdlib-2.1.0.jar;" +
                "C:\\Users\\artur\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar",
        "HijoKt"
    ).apply {
        redirectErrorStream(true)
    }

    val procesoejecutado = proceso.start()




    val output = OutputStreamWriter(procesoejecutado.outputStream)
    output.write("hola hijo\n")
    output.flush()

    val input = BufferedReader(InputStreamReader(procesoejecutado.inputStream)).readLine()
    print(input)
}