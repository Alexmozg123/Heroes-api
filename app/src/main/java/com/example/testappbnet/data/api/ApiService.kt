package com.example.testappbnet.data.api

import com.example.testappbnet.domain.Hero
import com.example.testappbnet.domain.HeroesList
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getListHeroes() : HeroesList

    @GET("character/{id-hero}")
    suspend fun getHeroById(
        @Path("id-hero") heroesId: Int
    ) : Hero
}