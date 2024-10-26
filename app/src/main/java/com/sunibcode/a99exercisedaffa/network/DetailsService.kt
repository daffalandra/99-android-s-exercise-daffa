package com.sunibcode.a99exercisedaffa.network

import com.sunibcode.a99exercisedaffa.model.ListingDetails
import retrofit2.Call
import retrofit2.http.GET

interface DetailsService {
    @GET("details/0.json")
    fun getDetails(): Call<List<ListingDetails>>
}