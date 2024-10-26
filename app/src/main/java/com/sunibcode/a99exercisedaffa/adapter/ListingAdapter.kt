package com.sunibcode.a99exercisedaffa.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunibcode.a99exercisedaffa.R
import com.sunibcode.a99exercisedaffa.model.Listing

class ListingAdapter(private val listings: List<Listing>) :
    RecyclerView.Adapter<ListingAdapter.ApartmentViewHolder>() {

    class ApartmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listingImage: ImageView = itemView.findViewById(R.id.listingImage)
        val listingName: TextView = itemView.findViewById(R.id.listingName)
        val listingAddress: TextView = itemView.findViewById(R.id.listingAddress)
        val listingDetails: TextView = itemView.findViewById(R.id.listingDetails)
        val listingPrice: TextView = itemView.findViewById(R.id.listingPrice)
        val listingCategory : TextView = itemView.findViewById(R.id.listingCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApartmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listing_item, parent, false)
        return ApartmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApartmentViewHolder, position: Int) {
        val listing = listings[position]

        // Load image using Glide
        Glide.with(holder.itemView.context)
            .load(listing.photo)
            .into(holder.listingImage)

        holder.listingName.text = listing.project_name
        holder.listingAddress.text = "${listing.address.street_name} - ${listing.address.district}"
        holder.listingCategory.text = "${listing.category} · ${listing.completed_at} · ${listing.tenure} yrs "
        holder.listingDetails.text = "${listing.attributes.bedrooms} Beds · ${listing.attributes.bathrooms} Baths · ${listing.attributes.area_size} sqft"
        holder.listingPrice.text = "$${listing.attributes.price}/mo"
    }

    override fun getItemCount() = listings.size
}