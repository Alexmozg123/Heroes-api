package com.example.testappbnet.domain

import com.example.testappbnet.domain.models.Hero
import com.example.testappbnet.domain.models.HeroesList

interface Repository {
    suspend fun getHeroesList(): HeroesList
    suspend fun getHeroById(heroId: Int): Hero
}