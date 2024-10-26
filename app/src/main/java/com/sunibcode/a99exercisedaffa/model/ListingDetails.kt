package com.sunibcode.a99exercisedaffa.model

data class ListingDetails(
    val address: AddressDetails,
    val attributes: AttributesDetails,
    val description: String,
    val id: Int,
    val photo: String,
    val project_name: String,
    val property_details: List<PropertyDetail>
)

data class AddressDetails(
    val map_coordinates: MapCoordinates,
    val subtitle: String,
    val title: String
)

data class MapCoordinates(
    val lat: Double,
    val lng: Double
)

data class AttributesDetails(
    val area_size: Int,
    val bathrooms: Int,
    val bedrooms: Int,
    val price: Int
)

data class PropertyDetail(
    val label: String,
    val text: String
)