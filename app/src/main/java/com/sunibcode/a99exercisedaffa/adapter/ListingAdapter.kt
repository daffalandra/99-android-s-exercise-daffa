package com.sunibcode.a99exercisedaffa.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunibcode.a99exercisedaffa.R
import com.sunibcode.a99exercisedaffa.listener.ListingListener
import com.sunibcode.a99exercisedaffa.model.Listing

class ListingAdapter(
    private val listings: List<Listing>
    //val listener: onListingClickListener
) :
    RecyclerView.Adapter<ListingAdapter.ListingViewHolder>() {
/*
        interface onListingClickListener {
        fun onListingClick(position: Int)
    }

 */
    class ListingViewHolder(view: View, /*val listener: onListingClickListener*/) : RecyclerView.ViewHolder(view) /*View.OnClickListener*/ {
        val listingImage: ImageView = view.findViewById(R.id.listingImage)
        val listingName: TextView = view.findViewById(R.id.listingName)
        val listingAddress: TextView = view.findViewById(R.id.listingAddress)
        val listingDetails: TextView = view.findViewById(R.id.listingDetails)
        val listingPrice: TextView = view.findViewById(R.id.listingPrice)
        val listingCategory : TextView = view.findViewById(R.id.listingCategory)
/*
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position!=RecyclerView.NO_POSITION){
                listener.onListingClick(position)
            }
        }
 */
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listing_item, parent, false)
        return ListingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
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
