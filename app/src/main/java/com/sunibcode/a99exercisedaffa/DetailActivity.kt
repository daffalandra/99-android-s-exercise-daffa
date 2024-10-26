package com.sunibcode.a99exercisedaffa

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sunibcode.a99exercisedaffa.MainActivity
import com.sunibcode.a99exercisedaffa.adapter.ListingAdapter
import com.sunibcode.a99exercisedaffa.model.Listing
import com.sunibcode.a99exercisedaffa.model.ListingDetails
import com.sunibcode.a99exercisedaffa.network.DetailsClient
import com.sunibcode.a99exercisedaffa.network.RetrofitClient
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
                    val listingDetails = response.body() ?: emptyList()
                    detailAdapter = DetailAdapter(listingDetails)
                    recyclerView.adapter = detailAdapter
                } else {
                    Toast.makeText(this@DetailActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ListingDetails>>, t: Throwable) {
                Toast.makeText(this@DetailActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    override fun onItemClick(position: Int) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity( intent)
    }
}