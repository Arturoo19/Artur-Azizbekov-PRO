import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    val cliente = OkHttpClient()
    val url = "hhtp://www.marca.com"
    val peticion = Request.Builder().url(url).build()
    val respuesta = cliente.newCall(peticion).execute()
    println(respuesta.body?.string())

}