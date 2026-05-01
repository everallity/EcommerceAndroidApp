package com.everallity.ecommerceandroidapp.features.cart.data.dto

import com.everallity.ecommerceandroidapp.features.cart.data.dto.CartItemDto
import com.google.gson.annotations.SerializedName

data class CartDto(
    @SerializedName(value = "id") val cartId: Int,
    @SerializedName(value = "clientId") val accountId: Long,
    @SerializedName(value = "final_amount") val total: Double,
    @SerializedName(value = "cartItemList") val itemList: List<CartItemDto>
)