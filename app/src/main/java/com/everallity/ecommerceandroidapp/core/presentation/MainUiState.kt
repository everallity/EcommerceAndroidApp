package com.everallity.ecommerceandroidapp.core.presentation

data class MainUiState(
    val cartId: Int = 0,
    val accountId: Int = 0,
    val cartItemCount: Int = 0,
    val isLoggedIn: Boolean = false
)
