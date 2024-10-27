package com.sunibcode.a99exercisedaffa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunibcode.a99exercisedaffa.R
import com.sunibcode.a99exercisedaffa.model.ListingDetails

class DetailAdapter(
    val listingDetails: ListingDetails?
):
    RecyclerView.Adapter<DetailAdapter.MyViewHolder>() {
    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val listingImage = view.findViewById<ImageView>(R.id.listingImage)
        val txtPrice = view.findViewById<TextView>(R.id.txtPrice)
        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtAddress = view.findViewById<TextView>(R.id.txtAddress)
        val txtSubtitle = view.findViewById<TextView>(R.id.txtSubtitle)
        val bedrooms = view.findViewById<TextView>(R.id.bedrooms)
        val bathrooms = view.findViewById<TextView>(R.id.bathrooms)
        val areaSize = view.findViewById<TextView>(R.id.areaSize)
        val txtPriceSqft = view.findViewById<TextView>(R.id.txtPriceSqft)
        val txtFloorLevel = view.findViewById<TextView>(R.id.txtFloorLevel)
        val txtOfBed = view.findViewById<TextView>(R.id.txtOfBed)
        val txtFacing = view.findViewById<TextView>(R.id.txtFacing)
        val txtBuiltYear = view.findViewById<TextView>(R.id.txtBuiltYear)
        val txtTenure = view.findViewById<TextView>(R.id.txtTenure)
        val txtType = view.findViewById<TextView>(R.id.txtType)
        val txtLastUpdated = view.findViewById<TextView>(R.id.txtLastUpdated)
        val txtListingDescription = view.findViewById<TextView>(R.id.txtListingDescription)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_detail,parent,false);
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        /*
        Glide.with(holder.itemView.context)
            .load(listingDetails.photo)
            .into(holder.listingImage)

         */

        holder.txtPrice.text = String.format("$%,d", listingDetails?.attributes?.price)
        holder.txtName.text = listingDetails?.project_name
        holder.txtAddress.text = listingDetails?.address?.title
        holder.txtSubtitle.text = listingDetails?.address?.subtitle
        holder.bedrooms.text = String.format("%,d Beds", listingDetails?.attributes?.bedrooms)
        holder.bathrooms.text = String.format("%,d Bathrooms", listingDetails?.attributes?.bathrooms)
        holder.areaSize.text = String.format("%,d sqft", listingDetails?.attributes?.area_size)
        holder.txtPriceSqft.text = listingDetails?.property_details?.get(0)?.text
        holder.txtFloorLevel.text = listingDetails?.property_details?.get(1)?.text
        holder.txtOfBed.text = listingDetails?.property_details?.get(2)?.text
        holder.txtFacing.text = listingDetails?.property_details?.get(3)?.text
        holder.txtBuiltYear.text = listingDetails?.property_details?.get(4)?.text
        holder.txtTenure.text = listingDetails?.property_details?.get(5)?.text
        holder.txtType.text = listingDetails?.property_details?.get(6)?.text
        holder.txtLastUpdated.text = listingDetails?.property_details?.get(7)?.text
        holder.txtListingDescription.text = listingDetails?.description
    }

    override fun getItemCount() = 1
}

