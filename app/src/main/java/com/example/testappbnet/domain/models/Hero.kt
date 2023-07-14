package com.example.testappbnet.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val id: Int,
    val name: String,
    val status: String,
    val gender: String,
    val image: String,
    val location: Location,
    val origin: Origin,
    val species: String,
    val created: String,
) : Parcelable
