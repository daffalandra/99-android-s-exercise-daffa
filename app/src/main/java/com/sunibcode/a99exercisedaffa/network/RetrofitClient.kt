package com.example.exercise_99group.data.remote

import com.sunibcode.a99exercisedaffa.network.ListingService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/"

    val instance: ListingService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ListingService::class.java)
    }
}