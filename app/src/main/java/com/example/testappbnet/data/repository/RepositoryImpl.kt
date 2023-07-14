package com.example.testappbnet.data.repository

import com.example.testappbnet.data.api.ApiService
import com.example.testappbnet.domain.Repository
import com.example.testappbnet.domain.models.Hero
import com.example.testappbnet.domain.models.Location
import com.example.testappbnet.domain.models.Origin

class RepositoryImpl(private val apiService: ApiService) : Repository {
    override suspend fun getHeroesList(): List<Hero> =
        apiService.getListHeroes().heroesList
            .map { item ->
                Hero(
                    item.id,
                    item.name,
                    item.status,
                    item.gender,
                    item.image,
                    Location(item.locationBin.name, item.locationBin.url),
                    Origin(item.originBin.name, item.originBin.url),
                    item.species,
                    item.created
                )
            }
}