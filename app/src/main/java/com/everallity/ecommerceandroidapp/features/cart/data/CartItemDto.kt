package com.everallity.ecommerceandroidapp.features.cart.data

import com.everallity.ecommerceandroidapp.features.catalog.data.ProductDto
import com.google.gson.annotations.SerializedName

data class CartItemDto(
    @SerializedName(value = "id") val itemId: Int,
    @SerializedName(value = "quantity") val quantity: Int,
    @SerializedName(value = "cart_id") val cartId: Int,
    @SerializedName(value = "product") val product: ProductDto,
    @SerializedName(value = "totalamount") val total: Double
)
