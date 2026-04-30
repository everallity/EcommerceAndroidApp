package com.everallity.ecommerceandroidapp.features.cart.domain.usecase

import com.everallity.ecommerceandroidapp.features.cart.domain.entity.CartItem
import com.everallity.ecommerceandroidapp.features.cart.domain.repository.CartRepository
import javax.inject.Inject

class DecreaseItemUseCase @Inject constructor(
    private val repository: CartRepository
) {
    suspend operator fun invoke(item: CartItem): Boolean {
        return repository.decreaseItem(item)
    }
}