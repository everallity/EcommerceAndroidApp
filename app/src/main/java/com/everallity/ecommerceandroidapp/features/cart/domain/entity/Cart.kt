package com.everallity.ecommerceandroidapp.features.cart.domain.entity

data class Cart(
    val cartId: Int,
    val accountId: Int,
    val total: Double,
    val cartItems: List<CartItem>
)