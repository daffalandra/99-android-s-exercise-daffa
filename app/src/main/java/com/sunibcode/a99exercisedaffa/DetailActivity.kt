package com.sunibcode.a99exercisedaffa

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunibcode.a99exercisedaffa.MainActivity
import com.sunibcode.a99exercisedaffa.adapter.DetailAdapter
import com.sunibcode.a99exercisedaffa.model.ListingDetails
import com.sunibcode.a99exercisedaffa.network.DetailsClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        findViewById<ImageView>(R.id.back_btn).setOnClickListener {
            finish()
        }
        DetailsClient.instance.getDetails().enqueue(object : Callback<ListingDetails> {
            override fun onResponse(
                call: Call<ListingDetails>,
                response: Response<ListingDetails>
            ) {
                if (response.isSuccessful) {
                    val listingDetails = response.body()
                    val listingImage = findViewById<ImageView>(R.id.listingImage)
                    val txtPrice = findViewById<TextView>(R.id.txtPrice)
                    val txtName = findViewById<TextView>(R.id.txtName)
                    val txtAddress = findViewById<TextView>(R.id.txtAddress)
                    val txtSubtitle = findViewById<TextView>(R.id.txtSubtitle)
                    val bedrooms = findViewById<TextView>(R.id.bedrooms)
                    val bathrooms = findViewById<TextView>(R.id.bathrooms)
                    val areaSize = findViewById<TextView>(R.id.areaSize)
                    val txtPriceSqft = findViewById<TextView>(R.id.txtPriceSqft)
                    val txtFloorLevel = findViewById<TextView>(R.id.txtFloorLevel)
                    val txtOfBed = findViewById<TextView>(R.id.txtOfBed)
                    val txtFacing = findViewById<TextView>(R.id.txtFacing)
                    val txtBuiltYear = findViewById<TextView>(R.id.txtBuiltYear)
                    val txtTenure = findViewById<TextView>(R.id.txtTenure)
                    val txtType = findViewById<TextView>(R.id.txtType)
                    val txtLastUpdated = findViewById<TextView>(R.id.txtLastUpdated)
                    val txtListingDescription = findViewById<TextView>(R.id.txtListingDescription)

                    /*
                    //Still error fetching image from json
                    Glide.with(applicationContext)
                        .load(listingDetails?.photo)
                        .error(R.drawable.ic_launcher_background)
                        .into(listingImage)

                     */

                    txtPrice.text = String.format("$%,d", listingDetails?.attributes?.price)
                    txtName.text = listingDetails?.project_name
                    txtAddress.text = listingDetails?.address?.title
                    txtSubtitle.text = listingDetails?.address?.subtitle
                    bedrooms.text = String.format("%,d Beds", listingDetails?.attributes?.bedrooms)
                    bathrooms.text = String.format("%,d Bathrooms", listingDetails?.attributes?.bathrooms)
                    areaSize.text = String.format("%,d sqft", listingDetails?.attributes?.area_size)
                    txtPriceSqft.text = listingDetails?.property_details?.get(0)?.text
                    txtFloorLevel.text = listingDetails?.property_details?.get(1)?.text
                    txtOfBed.text = listingDetails?.property_details?.get(2)?.text
                    txtFacing.text = listingDetails?.property_details?.get(3)?.text
                    txtBuiltYear.text = listingDetails?.property_details?.get(4)?.text
                    txtTenure.text = listingDetails?.property_details?.get(5)?.text
                    txtType.text = listingDetails?.property_details?.get(6)?.text
                    txtLastUpdated.text = listingDetails?.property_details?.get(7)?.text
                    txtListingDescription.text = listingDetails?.description

                }else {
                    Toast.makeText(this@DetailActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(
                call: Call<ListingDetails?>,
                t: Throwable
            ) {
                Toast.makeText(this@DetailActivity, "Error1: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}