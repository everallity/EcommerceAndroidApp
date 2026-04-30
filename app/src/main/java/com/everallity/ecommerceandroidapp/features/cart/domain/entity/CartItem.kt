package com.everallity.ecommerceandroidapp.features.cart.domain.entity

import com.everallity.ecommerceandroidapp.features.catalog.domain.Product

data class CartItem(
    val itemId: Int,
    val cartId: Int,
    val quantity: Int,
    val total: Double,
    val product: Product
)