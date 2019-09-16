package com.jfboily.democoroutinesrestapi

import com.jfboily.democoroutinesrestapi.domain.Biere
import com.jfboily.democoroutinesrestapi.domain.BiereRepo
import com.jfboily.democoroutinesrestapi.domain.Brasserie
import com.jfboily.democoroutinesrestapi.domain.BrasserieRepo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener

@SpringBootApplication
class DemoCoroutinesRestapiApplication(val brasserieRepo: BrasserieRepo, val biereRepo: BiereRepo) {

    @EventListener
    fun seed(contextRefreshedEvent: ContextRefreshedEvent) {
        val souche = brasserieRepo.save(Brasserie(0, "La Souche", "quebec", true))
        val griendel = brasserieRepo.save(Brasserie(0, "Griendel", "quebec", false))
        val inox = brasserieRepo.save(Brasserie(0, "L'Inox", "quebec", true))
        val naufrageur = brasserieRepo.save(Brasserie(0, "Le Naufrageur", "carleton", true))
        val siboire = brasserieRepo.save(Brasserie(0, "Siboire", "sherbrooke", false))
        val dieuduciel = brasserieRepo.save(Brasserie(0, "Dieu du ciel!", "montreal", true))

        biereRepo.save(Biere(0, "Canardiere", "Double IPA", 7.0, souche))
        biereRepo.save(Biere(0, "Franc-Bois", "Biere de ble aux framboises", 4.5, souche))
        biereRepo.save(Biere(0, "Gros Pin", "Irish Red", 5.0, souche))
        biereRepo.save(Biere(0, "Limoilou Beach", "Biere de ble sure aux cassis", 6.5, souche))

        biereRepo.save(Biere(0, "St-So", "Rye Bitter", 4.8, griendel))
        biereRepo.save(Biere(0, "Kolsch du clocher", "Ale lagerisee", 5.0, griendel))
        biereRepo.save(Biere(0, "Stinson Beach", "IPA Americaine", 6.3, griendel))
        biereRepo.save(Biere(0, "Jolly Jumper", "Session IPA", 3.2, griendel))

        biereRepo.save(Biere(0, "La Labrosse", "Blonde & Lager", 5.0, inox))
        biereRepo.save(Biere(0, "La Trouble-fete", "Blanche croisee", 4.5, inox))
        biereRepo.save(Biere(0, "La Sortilege", "Stout", 5.0, inox))
        biereRepo.save(Biere(0, "La Trois de pique", "Rousse ESB anglaise", 4.5, inox))

        biereRepo.save(Biere(0, "Doris", "Lager blonde", 4.0, naufrageur))
        biereRepo.save(Biere(0, "Colborne", "Dry stout", 5.2, naufrageur))
        biereRepo.save(Biere(0, "Achab", "Double IPA", 7.0, naufrageur))
        biereRepo.save(Biere(0, "Mille Sabords", "Viellie en fut de houblon", 10.0, naufrageur))

        biereRepo.save(Biere(0, "Sherbiere", "Lager sherbrookoise", 5.2, siboire))
        biereRepo.save(Biere(0, "Trip d'automne", "Triple belge", 7.0, siboire))
        biereRepo.save(Biere(0, "A.A.A", "Ale ambreee americaine", 4.4, siboire))
        biereRepo.save(Biere(0, "Folle Mesure", "Session NEIPA", 4.0, siboire))

        biereRepo.save(Biere(0, "Lazer Lager", "Lager de soif", 4.3, dieuduciel))
        biereRepo.save(Biere(0, "Fumisterie", "Ale au chanvre", 5.5, dieuduciel))
        biereRepo.save(Biere(0, "Dublin Calling", "Dry stout", 4.0, dieuduciel))
        biereRepo.save(Biere(0, "Peche Mortel", "Stout au cacao et vanille", 9.5, dieuduciel))
    }
}

fun main(args: Array<String>) {
    runApplication<DemoCoroutinesRestapiApplication>(*args)
}


