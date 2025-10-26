import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val jobs = mutableListOf<Job>()
        for (tabla in 1..10){
            val job = launch {
                print("soy la tabla del $tabla \n")

                for (i in 1..10){
                    println("$tabla * $i ${tabla* i}")
                }
            }
            jobs.add(job)

        }
        jobs.joinAll()
    }
}
