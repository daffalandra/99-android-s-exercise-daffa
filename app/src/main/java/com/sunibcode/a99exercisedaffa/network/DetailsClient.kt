package com.sunibcode.a99exercisedaffa.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DetailsClient {
    private const val BASE_URL = "https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/"

    val instance: DetailsService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(DetailsService::class.java)
    }
}