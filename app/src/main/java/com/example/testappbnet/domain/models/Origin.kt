package com.example.testappbnet.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Origin (
    val name: String,
    val url: String
) : Parcelable
