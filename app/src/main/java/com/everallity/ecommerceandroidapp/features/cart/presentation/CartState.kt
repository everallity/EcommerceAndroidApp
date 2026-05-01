package com.everallity.ecommerceandroidapp.features.cart.presentation

import com.everallity.ecommerceandroidapp.features.cart.domain.entity.CartItem

data class CartState(
    val isLoading: Boolean = false,
    val itemList: List<CartItem> = emptyList(),
    val error: String? = null
)