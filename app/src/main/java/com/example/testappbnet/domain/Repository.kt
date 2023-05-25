package com.example.testappbnet.domain

interface Repository {

    suspend fun getHeroesList(): HeroesList

    suspend fun getHeroById(heroId: Int): Hero
}