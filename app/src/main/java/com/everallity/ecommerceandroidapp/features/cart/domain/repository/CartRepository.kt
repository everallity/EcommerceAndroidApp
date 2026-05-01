package com.everallity.ecommerceandroidapp.features.cart.domain.repository

import com.everallity.ecommerceandroidapp.features.auth.domain.entity.Account
import com.everallity.ecommerceandroidapp.features.cart.domain.entity.Cart
import com.everallity.ecommerceandroidapp.features.cart.domain.entity.CartItem

interface CartRepository {
    suspend fun getCart(account: Account): Cart
    suspend fun addItem(accountId: Int, productId: Int): Boolean
    suspend fun decreaseItem(item: CartItem): Boolean
    suspend fun increaseItem(item: CartItem): Boolean
    suspend fun deleteItem(item: CartItem): Boolean
}