package com.jjcdutra.livrovirtual.novoautor

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AutoresController(
    @PersistenceContext
    private val manager: EntityManager
) {

    @PostMapping("/autores")
    @Transactional
    fun cria(@RequestBody @Valid request: NovoAutorRequest): String {
        val autor = request.toModel()
        manager.persist(autor)
        return autor.toString()
    }
}