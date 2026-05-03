package com.everallity.ecommerceandroidapp.features.auth.presentation

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val isSigningIn: Boolean = false,
    val isSigningUp: Boolean = false,
    val error: String? = null,
)