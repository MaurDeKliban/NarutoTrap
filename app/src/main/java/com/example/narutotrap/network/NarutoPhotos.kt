package com.example.narutotrap.network

import com.squareup.moshi.Json

data class NarutoPhotos(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String
)