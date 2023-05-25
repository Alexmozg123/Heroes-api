package com.example.testappbnet.data.repository

import com.example.testappbnet.data.api.RetrofitInstance
import com.example.testappbnet.domain.Hero
import com.example.testappbnet.domain.HeroesList
import com.example.testappbnet.domain.Repository

class RepositoryImpl : Repository {

    override suspend fun getHeroesList() : HeroesList {
        return RetrofitInstance.api.getListHeroes()
    }

    override suspend fun getHeroById(heroId: Int) : Hero {
        return RetrofitInstance.api.getHeroById(heroId)
    }
}