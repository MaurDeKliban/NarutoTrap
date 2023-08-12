package com.example.narutotrap.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NarutoCharacters(
    val id: String,
    val name: String,
    val images: List<String>? = null,
    val debut: Debut? = null,
    val jutsu: List<String>? = null,
    val personal: Personal? = null,
    val uniqueTraits: List<String>? = null
)

@JsonClass(generateAdapter = true)
data class Debut(
    val manga: String? = null,
    val anime: String? = null,
    val novel: String? = null,
    val movie: String? = null,
    val ova: String? = null,
    val game: String? = null,
    val appearsIn: String? = "$manga, $anime, $movie, $novel, $ova, $game"
)

@JsonClass(generateAdapter = true)
data class Personal(
    val species: String? = null,
    val status: String? = null,
    val kekkeiGenkai: String? = null,
    val classification: String? = null,
    val jinchuriki: List<String>? = null,
    val titles: List<String>? = null
)
 @JsonClass(generateAdapter = true)
data class AllCharacters(
     val characters: List<NarutoCharacters>
)

