package com.example.testappbnet.domain.models

import com.squareup.moshi.Json

data class HeroesList(
    @Json(name = "info")
    val info: Info,
    @Json(name = "results")
    val heroesList: List<Hero>
)