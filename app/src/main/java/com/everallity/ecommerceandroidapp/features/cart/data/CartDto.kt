package com.everallity.ecommerceandroidapp.features.cart.data

import com.google.gson.annotations.SerializedName

data class CartDto(
    @SerializedName(value = "id") val cartId: Int,
    @SerializedName(value = "clientId") val accountId: Int,
    @SerializedName(value = "final_amount") val total: Double,
    @SerializedName(value = "cartItemList") val itemList: List<CartItemDto>
)