
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinx.coroutines.runBlocking
import java.net.URL

//data class Brasserie(
//    val id: Long,
//    val nom: String,
//    val ville: String,
//    val terrasse: Boolean
//)
//
//data class Biere(
//    val id: Long,
//    val nom: String,
//    val type: String,
//    val abv: Double,
//    val brasserie: Brasserie
//)



fun demo1() = runBlocking {
    val startTime = System.currentTimeMillis()
    // obtient une liste de brasseries pour une villes
    val brasseries : List<Brasserie> = jacksonObjectMapper().readValue(URL("http://localhost:8585/brasserie"),
        (object : TypeReference<List<Brasserie>>() {}))

    // si ok, obtient la liste des bieres de chaque brasserie
    brasseries.forEach {
        val bieres : List<Biere> = jacksonObjectMapper().readValue(URL("http://localhost:8585/biere/brasserie/${it.id}"),
            (object: TypeReference<List<Biere>>() {}))

        println("\n\n\nBieres de ${it.nom} :")
        bieres.forEach {
            println("${it.nom} - ${it.type} - ${it.abv}")
        }
    }
    val endTime = System.currentTimeMillis()
    println("\n\n\n===========\nTemps total : ${(endTime - startTime) / 1000.0} sec.")
}