package com.sunibcode.a99exercisedaffa.model

data class Listing(
    val address: Address,
    val attributes: Attributes,
    val category: String,
    val completed_at: String,
    val id: Int,
    val photo: String,
    val project_name: String,
    val tenure: Int,

)

data class Address(
    val district: String,
    val street_name: String
)

data class Attributes(
    val area_size: Int,
    val bathrooms: Int,
    val bedrooms: Int,
    val price: Int
)