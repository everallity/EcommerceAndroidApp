package com.everallity.ecommerceandroidapp.features.cart.domain.usecase

import com.everallity.ecommerceandroidapp.features.auth.domain.entity.Account
import com.everallity.ecommerceandroidapp.features.cart.domain.entity.Cart
import com.everallity.ecommerceandroidapp.features.cart.domain.repository.CartRepository
import javax.inject.Inject

class GetCartUseCase @Inject constructor(
    private val repository: CartRepository
) {
    suspend operator fun invoke(account: Account): Cart {
        return repository.getCart(account)
    }
}