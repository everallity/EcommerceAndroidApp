package com.everallity.ecommerceandroidapp.features.catalog.data

import com.everallity.ecommerceandroidapp.features.catalog.data.mapper.toDomain
import com.everallity.ecommerceandroidapp.features.catalog.data.remote.ProductApi
import com.everallity.ecommerceandroidapp.features.catalog.domain.Product
import com.everallity.ecommerceandroidapp.features.catalog.domain.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
): ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            try {
                val productDtos = api.getProducts()
                productDtos.map { dto -> dto.toDomain("192.168.31.10") }
            } catch (e: Exception) {
                e.printStackTrace()
                emptyList()
            }
        }
    }
}