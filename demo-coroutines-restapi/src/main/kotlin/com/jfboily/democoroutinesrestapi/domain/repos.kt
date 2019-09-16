package com.jfboily.democoroutinesrestapi.domain

import org.springframework.data.repository.CrudRepository

interface BrasserieRepo : CrudRepository<Brasserie, Long>

interface BiereRepo : CrudRepository<Biere, Long>