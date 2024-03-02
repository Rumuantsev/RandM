package com.example.rm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {
    @GET("character")
    suspend fun getResponse() : CharacterResponse
}

object RetrofitClient {
    private val baseUrl = "https://rickandmortyapi.com/api/"

    fun createService(): RetrofitServices {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitServices::class.java)
    }
}