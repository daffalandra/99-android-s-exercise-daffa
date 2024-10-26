package com.sunibcode.a99exercisedaffa.listener

import com.sunibcode.a99exercisedaffa.model.Listing

interface ListingListener {
    fun onListingClick(listing: Listing)
}