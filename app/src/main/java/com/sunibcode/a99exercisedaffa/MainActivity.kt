package com.sunibcode.a99exercisedaffa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_99group.data.remote.RetrofitClient
import com.sunibcode.a99exercisedaffa.adapter.ListingAdapter
import com.sunibcode.a99exercisedaffa.model.Listing
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), ListingAdapter.onListingClickListener {

    private lateinit var listingAdapter: ListingAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing)
        recyclerView = findViewById(R.id.listingItem)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch data from API
        fetchListingData()
    }

    private fun fetchListingData() {
        RetrofitClient.instance.getListing().enqueue(object : Callback<List<Listing>> {
            override fun onResponse(
                call: Call<List<Listing>>,
                response: Response<List<Listing>>
            ) {
                if (response.isSuccessful) {
                    val listing = response.body() ?: emptyList()
                    listingAdapter = ListingAdapter(listing, this@MainActivity)
                    recyclerView.adapter = listingAdapter
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Listing>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }

    override fun onListingClick(position: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        startActivity( intent)
    }
}