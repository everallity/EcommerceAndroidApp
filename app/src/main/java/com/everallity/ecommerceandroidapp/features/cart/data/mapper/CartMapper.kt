package com.everallity.ecommerceandroidapp.features.cart.data.mapper

import com.everallity.ecommerceandroidapp.features.cart.data.CartDto
import com.everallity.ecommerceandroidapp.features.cart.domain.entity.Cart

fun CartDto.toDomain(): Cart {
    return Cart(
        cartId = this.cartId,
        accountId = this.accountId,
        cartItems = this.itemList.map { it.toDomain() },
        total = this.total
    )
}