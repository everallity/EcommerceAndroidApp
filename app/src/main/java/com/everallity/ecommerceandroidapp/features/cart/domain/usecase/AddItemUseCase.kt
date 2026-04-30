package com.everallity.ecommerceandroidapp.features.cart.domain.usecase

import com.everallity.ecommerceandroidapp.features.cart.domain.repository.CartRepository
import javax.inject.Inject

class AddItemUseCase @Inject constructor(
    private val repository: CartRepository
) {
    suspend operator fun invoke(accountId: Int, productId: Int): Boolean {
        return repository.addItem(accountId, productId)
    }
}