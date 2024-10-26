package com.sunibcode.a99exercisedaffa

import android.os.Bundle
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunibcode.a99exercisedaffa.adapter.DetailsAdapter
import com.sunibcode.a99exercisedaffa.adapter.ListingAdapter
import com.sunibcode.a99exercisedaffa.model.AddressDetails
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
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        findViewById<ImageView>(R.id.back_btn).setOnClickListener{
            finish()
        }

        scrollView = findViewById(R.id.scroll_item)//
        scrollView.isFillViewport = true //

        // Fetch data from API
        fetchListingData()
    }

    private fun fetchListingData() {
        DetailsClient.instance.getDetails().enqueue(object : Callback<List<ListingDetails>> {

                }
            }


            override fun onFailure(call: Call<List<ListingDetails>>, t: Throwable) {
                Toast.makeText(this@detailsActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
