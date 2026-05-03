package com.everallity.ecommerceandroidapp.features.catalog.domain

import androidx.compose.runtime.Stable

@Stable
data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val imageUrl: String,
    val price: String,
    val brand: String
)