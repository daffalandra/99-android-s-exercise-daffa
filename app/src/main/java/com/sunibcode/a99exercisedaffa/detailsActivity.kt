package com.sunibcode.a99exercisedaffa

import android.os.Bundle
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sunibcode.a99exercisedaffa.adapter.DetailsAdapter
import com.sunibcode.a99exercisedaffa.adapter.ListingAdapter
import com.sunibcode.a99exercisedaffa.model.Listing
import com.sunibcode.a99exercisedaffa.model.ListingDetails
import com.sunibcode.a99exercisedaffa.network.DetailsClient
import com.sunibcode.a99exercisedaffa.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class detailsActivity : AppCompatActivity() {

    private lateinit var detailsAdapter: DetailsAdapter //
    private lateinit var scrollView: ScrollView//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        scrollView = findViewById(R.id.scroll_item)//
        scrollView.isFillViewport = true //

        // Fetch data from API
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
                    detailsAdapter = DetailsAdapter(ListingDetails) //
                    scrollView.adapter = detailsAdapter //
                }

                else {
                    Toast.makeText(this@detailsActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<ListingDetails>>, t: Throwable) {
                Toast.makeText(this@detailsActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
