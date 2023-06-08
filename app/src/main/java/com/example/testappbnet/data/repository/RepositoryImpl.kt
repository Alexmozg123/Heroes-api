package com.example.testappbnet.data.repository

import com.example.testappbnet.data.api.RetrofitInstance
import com.example.testappbnet.domain.models.Hero
import com.example.testappbnet.domain.models.HeroesList
import com.example.testappbnet.domain.Repository

class RepositoryImpl : Repository {

    override suspend fun getHeroesList() : HeroesList {
        return RetrofitInstance.api.getListHeroes()
    }

    override suspend fun getHeroById(heroId: Int) : Hero {
        return RetrofitInstance.api.getHeroById(heroId)
    }
}