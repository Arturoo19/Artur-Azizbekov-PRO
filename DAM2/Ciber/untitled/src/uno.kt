import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args:Array<String>) {
    var linea = BufferedReader(InputStreamReader(ProcessBuilder("java","-cp","C:\\GitHub\\Artur-Azizbekov-PRO\\DAM2\\untitled\\out\\production\\untitled","LlamarKt").start().inputStream)).readLine()
    println(linea)

}