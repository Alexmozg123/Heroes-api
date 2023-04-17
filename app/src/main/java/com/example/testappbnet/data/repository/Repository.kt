package com.example.testappbnet.data.repository

import com.example.testappbnet.data.api.RetrofitInstance
import com.example.testappbnet.models.Hero

class Repository {

    suspend fun getHeroesList() : List<Hero>? {
        val request = RetrofitInstance.api.getListHeroes()
        if (request.isSuccessful){
            return request.body()
        }
        return null
    }

    suspend fun getHeroById(heroId: Int) : Hero? {
        val request = RetrofitInstance.api.getHeroById(heroId)
        if (request.isSuccessful){
            return request.body()
        }
        return null
    }
}