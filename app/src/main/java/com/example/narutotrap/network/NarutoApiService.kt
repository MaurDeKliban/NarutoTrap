package com.example.narutotrap.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.narutodb.xyz/"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()
interface NarutoApiService {
    @GET("character")
    suspend fun getAllСharacter(): List<AllCharacters>
}
object NarutoApi {
    val retrofitService: NarutoApiService by lazy {
        retrofit.create(NarutoApiService::class.java)
    }
}