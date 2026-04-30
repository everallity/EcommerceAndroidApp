package com.everallity.ecommerceandroidapp.features.catalog.domain.usecase

import com.everallity.ecommerceandroidapp.features.catalog.domain.Product
import com.everallity.ecommerceandroidapp.features.catalog.domain.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): List<Product> {
        return repository.getProducts().sortedBy { it.name }
    }
}