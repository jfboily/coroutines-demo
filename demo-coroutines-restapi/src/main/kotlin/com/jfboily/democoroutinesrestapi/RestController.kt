package com.jfboily.democoroutinesrestapi

import com.jfboily.democoroutinesrestapi.domain.Biere
import com.jfboily.democoroutinesrestapi.domain.BiereRepo
import com.jfboily.democoroutinesrestapi.domain.Brasserie
import com.jfboily.democoroutinesrestapi.domain.BrasserieRepo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController(val brasserieRepo: BrasserieRepo, val biereRepo: BiereRepo) {

    private val SLEEPTIME = 1000L

    @GetMapping("/brasserie")
    fun getBrasseries(): List<Brasserie> {
        Thread.sleep(SLEEPTIME)
        return brasserieRepo.findAll().toList()
    }

    @GetMapping("/brasserie/{id}")
    fun getBrasserie(@PathVariable("id") id: Long): Brasserie {
        Thread.sleep(SLEEPTIME)
        return brasserieRepo.findById(id).orElseThrow { RuntimeException("Not found.") }
    }

    @GetMapping("/brasserie/ville/{ville}")
    fun getBrasserieByVille(@PathVariable("ville") ville: String): List<Brasserie> {
        Thread.sleep(SLEEPTIME)
        return brasserieRepo.findAll().filter { it.ville == ville }.toList()
    }


    @GetMapping("/biere")
    fun getBieres(): List<Biere> {
        Thread.sleep(SLEEPTIME)
        return biereRepo.findAll().toList()
    }

    @GetMapping("/biere/{id}")
    fun getBiere(@PathVariable("id") id: Long): Biere {
        Thread.sleep(SLEEPTIME)
        return biereRepo.findById(id).orElseThrow { RuntimeException("Not found.")}
    }

    @GetMapping("/biere/brasserie/{brasserieId}")
    fun getBiereByBrasserie(@PathVariable("brasserieId") brasserieId: Long): List<Biere> {
        Thread.sleep(SLEEPTIME)
        return biereRepo.findAll().filter { it.brasserie.id == brasserieId }.toList()
    }
}