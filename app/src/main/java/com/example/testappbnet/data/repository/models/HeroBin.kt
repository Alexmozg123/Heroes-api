package com.example.testappbnet.data.repository.models

import com.squareup.moshi.Json

data class HeroBin(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    @Json(name = "location")
    val locationBin: LocationBin,
    val name: String,
    @Json(name = "origin")
    val originBin: OriginBin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)