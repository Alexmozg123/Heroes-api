package com.example.testappbnet.domain

import com.example.testappbnet.domain.models.Hero

interface Repository {
    suspend fun getHeroesList(): List<Hero>
}