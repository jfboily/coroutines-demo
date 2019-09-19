
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.net.URL

data class Brasserie(
    val id: Long,
    val nom: String,
    val ville: String,
    val terrasse: Boolean
)

data class Biere(
    val id: Long,
    val nom: String,
    val type: String,
    val abv: Double,
    val brasserie: Brasserie
)

fun getBrasseries(): List<Brasserie> {
    return jacksonObjectMapper().readValue(URL("http://localhost:8585/brasserie"),
        (object : TypeReference<List<Brasserie>>() {}))
}

fun getBieres(brasserieId: Long): List<Biere> {
    println(">>>>>> getBiere for $brasserieId from Thread ${Thread.currentThread().name}")
    return jacksonObjectMapper().readValue(URL("http://localhost:8585/biere/brasserie/$brasserieId"),
        (object: TypeReference<List<Biere>>() {}))
}

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    // obtient une liste de brasseries pour une villes
    val brasseries : List<Brasserie> = async { getBrasseries() }.await()

    // si ok, obtient la liste des bieres de chaque brasserie
    val bieres = mutableMapOf<Brasserie, Deferred<List<Biere>>>()

    brasseries.forEach {
        bieres[it] = async(Dispatchers.IO) { getBieres(it.id) }
    }

    for ((k,v) in bieres) {
        println("\n\n\nBieres de ${k.nom} :")
        v.await().forEach {
            println("${it.nom} - ${it.type} - ${it.abv}")
        }
    }

    val endTime = System.currentTimeMillis()
    println("\n\n\n===========\nTemps total : ${(endTime - startTime) / 1000.0} sec.")
}