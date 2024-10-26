package com.sunibcode.a99exercisedaffa.network

import com.sunibcode.a99exercisedaffa.model.Listing
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("listings.json")
    fun getApartments(): Call<List<Listing>>
}