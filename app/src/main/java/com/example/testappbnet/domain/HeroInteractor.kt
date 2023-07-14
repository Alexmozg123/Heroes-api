package com.example.testappbnet.domain

import com.example.testappbnet.domain.models.Hero

class HeroInteractor(
    private val repository: Repository
) {
    suspend fun getHeroesList(): List<Hero> = repository.getHeroesList()
}