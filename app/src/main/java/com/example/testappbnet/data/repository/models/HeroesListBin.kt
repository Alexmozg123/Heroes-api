package com.example.testappbnet.data.repository.models

import com.squareup.moshi.Json

data class HeroesListBin(
    @Json(name = "info")
    val infoBin: InfoBin,
    @Json(name = "results")
    val heroesList: List<HeroBin>
)