package com.everallity.ecommerceandroidapp.features.cart.data.mapper

import com.everallity.ecommerceandroidapp.features.cart.data.CartItemDto
import com.everallity.ecommerceandroidapp.features.cart.domain.entity.CartItem
import com.everallity.ecommerceandroidapp.features.catalog.data.mapper.toDomain

fun CartItemDto.toDomain(): CartItem {
    return CartItem(
        cartId = this.cartId,
        product = this.product.toDomain("192.168.31.10" ),
        total = this.total,
        itemId = this.itemId,
        quantity = this.quantity
    )
}