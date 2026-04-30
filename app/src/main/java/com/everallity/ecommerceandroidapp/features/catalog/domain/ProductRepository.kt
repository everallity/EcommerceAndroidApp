package com.everallity.ecommerceandroidapp.features.catalog.domain

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}