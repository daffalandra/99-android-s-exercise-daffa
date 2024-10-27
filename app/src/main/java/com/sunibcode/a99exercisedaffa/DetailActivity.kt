package com.sunibcode.a99exercisedaffa

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sunibcode.a99exercisedaffa.adapter.DetailAdapter
import com.sunibcode.a99exercisedaffa.model.ListingDetails
import com.sunibcode.a99exercisedaffa.network.DetailsClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    private lateinit var detailAdapter: DetailAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        findViewById<ImageView>(R.id.back_btn).setOnClickListener {
            finish()
        }
        fetchListingData()
    }

    private fun fetchListingData() {
        DetailsClient.instance.getDetails().enqueue(object : Callback<List<ListingDetails>> {
            override fun onResponse(
                call: Call<List<ListingDetails>>,
                response: Response<List<ListingDetails>>
            ) {
                if (response.isSuccessful) {
                    val listingdetails = response.body() ?: emptyList()
                    detailAdapter = DetailAdapter(listingdetails)
                    recyclerView.adapter = detailAdapter
                } else {
                    Toast.makeText(this@DetailActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(
                call: Call<List<ListingDetails>>,
                t: Throwable
            ) {
                Toast.makeText(this@DetailActivity, "Error1: ${t.message}", Toast.LENGTH_LONG).show()
                Log.e("DetailActivity", "Error fetching data", t)
            }
        })
    }
}