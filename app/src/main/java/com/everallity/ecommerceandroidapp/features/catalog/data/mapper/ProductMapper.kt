package com.everallity.ecommerceandroidapp.features.catalog.data.mapper

import com.everallity.ecommerceandroidapp.features.catalog.data.ProductDto
import com.everallity.ecommerceandroidapp.features.catalog.domain.Product

fun ProductDto.toDomain(baseIp: String): Product {
    return Product(
        id = this.id,
        name = this.name,
        brand = this.brand,
        imageUrl = this.image.replace("localhost", baseIp),
        price = "$${this.price}", // Adding a currency symbol for the UI
        category = this.cat
    )
}