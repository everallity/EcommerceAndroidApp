package com.everallity.ecommerceandroidapp.features.catalog.data

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("product_id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("stock") val stock: Int,
    @SerializedName("brand") val brand: String,
    @SerializedName("category") val cat: String,
    @SerializedName("image") val image: String,
    @SerializedName("description") val desc: String,
    @SerializedName("price") val price: Double
)
