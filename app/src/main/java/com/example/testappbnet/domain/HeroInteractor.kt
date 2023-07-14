package com.example.testappbnet.domain

import com.example.testappbnet.domain.models.Hero
import javax.inject.Inject

class HeroInteractor @Inject constructor(
    private val repository: Repository
) {
    suspend fun getHeroesList(): List<Hero> = repository.getHeroesList()
}