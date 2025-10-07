import model.*

fun main() {
    //var persona = Persona("Artur","Azizbekov","12133d")
    //persona.mostrarDatos()
    //var trabajador: Trabajador = Trabajador("Artur","Azizbekov","12133d",1212,2121,1222,"dsdsd",true)
    //trabajador.mostrarDatos()
    val asalariado = Asalariado("Artur","Azizbekov","12133d",1212.0,2121,0.10)
    val autonomo = Autonomo("Artur","Azizbekov","12133d",1212.0,true,1)
    val jefe = Jefe("Artur","Azizbekov","12133d",1212.0,1)
    val directivo = Directivo("Artur","Azizbekov","12133d",1212,"dsdss",123)

    val trabajadores = arrayListOf<Persona>(asalariado,autonomo,jefe,directivo)
    /*trabajadores.forEach {
        if (it is Trabajador) {
            println("Calculando salario del trabajador: ${it.calcularSalarioNeto()}")
        }
        it.mostrarDatos()
    }*/


    trabajadores.forEach {

        if (it is Sindicato){
            it.calcularBeneficios()
            it.bajaSueldos(trabajadores.filter { it !is Directivo } as ArrayList<Trabajador>)
        }
    }
    println(asalariado.calcularSalarioNeto())

}