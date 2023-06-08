package com.example.testappbnet.data.api

import com.example.testappbnet.domain.models.Hero
import com.example.testappbnet.domain.models.HeroesList
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