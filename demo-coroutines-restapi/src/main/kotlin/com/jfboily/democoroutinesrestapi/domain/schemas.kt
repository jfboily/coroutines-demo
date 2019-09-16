package com.jfboily.democoroutinesrestapi.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Brasserie(
        @Id @GeneratedValue val id: Long,
        val nom: String,
        val ville: String,
        val terrasse: Boolean
)

@Entity
data class Biere(
        @Id @GeneratedValue val id: Long,
        val nom: String,
        val type: String,
        val abv: Double,
        @ManyToOne
        val brasserie: Brasserie
)