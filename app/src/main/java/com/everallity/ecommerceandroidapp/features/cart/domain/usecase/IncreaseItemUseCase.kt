package com.everallity.ecommerceandroidapp.features.cart.domain.usecase

import com.everallity.ecommerceandroidapp.features.cart.domain.entity.CartItem
import com.everallity.ecommerceandroidapp.features.cart.domain.repository.CartRepository
import javax.inject.Inject

class IncreaseItemUseCase @Inject constructor(
    private val repository: CartRepository
) {
    suspend operator fun invoke(item: CartItem): Boolean {
        return repository.increaseItem(item)
    }
}