package com.example.testappbnet.data.api

import com.example.testappbnet.data.repository.models.HeroesListBin
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getListHeroes() : HeroesListBin
}