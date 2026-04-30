package com.everallity.ecommerceandroidapp.features.catalog.presentation

import com.everallity.ecommerceandroidapp.features.catalog.domain.Product

data class CatalogState(
    val isLoading: Boolean = false,
    val productList: List<Product> = emptyList(),
    val error: String? = null
)
