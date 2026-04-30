package com.everallity.ecommerceandroidapp.features.cart.data

import android.util.Log
import com.everallity.ecommerceandroidapp.features.auth.entity.Account
import com.everallity.ecommerceandroidapp.features.cart.data.mapper.toDomain
import com.everallity.ecommerceandroidapp.features.cart.data.remote.CartApi
import com.everallity.ecommerceandroidapp.features.cart.domain.entity.Cart
import com.everallity.ecommerceandroidapp.features.cart.domain.entity.CartItem
import com.everallity.ecommerceandroidapp.features.cart.domain.repository.CartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val api: CartApi
) : CartRepository {
    override suspend fun getCart(account: Account): Cart {
        return withContext(Dispatchers.IO) {
            try {
                val cartDto = api.getCart(
                    account.accountId,
                    account.email,
                    account.password,
                    account.type,
                    account.username
                )
                cartDto.toDomain()
            } catch (e: Exception) {
                e.printStackTrace()
                Cart(0, account.accountId, 0.0, emptyList())
            }
        }
    }

    override suspend fun addItem(accountId: Int, productId: Int): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                api.addItem(accountId, productId)
            } catch (e: Exception) {
                e.printStackTrace()
                false
            }
        }
    }

    override suspend fun decreaseItem(item: CartItem): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                api.decreaseCartItem(
                    item.cartId,
                    item.quantity,
                    item.itemId,
                    item.product.id,
                    item.total
                )
            } catch (e: Exception) {
                e.printStackTrace()
                false
            }
        }
    }

    override suspend fun increaseItem(item: CartItem): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                api.increaseCartItem(
                    item.cartId,
                    item.quantity,
                    item.itemId,
                    item.product.id,
                    item.total
                )
            } catch (e: Exception) {
                e.printStackTrace()
                false
            }
        }
    }

    override suspend fun deleteItem(item: CartItem): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                api.deleteCartItem(
                    item.cartId,
                    item.quantity,
                    item.itemId,
                    item.product.id,
                    item.total
                )
            } catch (e: Exception) {
                e.printStackTrace()
                false
            }
        }
    }
}
