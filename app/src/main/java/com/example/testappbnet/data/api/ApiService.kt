package com.example.testappbnet.data.api

import com.example.testappbnet.models.Hero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getListHeroes() : Response<List<Hero>>

    @GET("character/{id-hero}")
    suspend fun getHeroById(
        @Path("id-hero") heroesId: Int
    ): Response<Hero>
}