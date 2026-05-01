package com.everallity.ecommerceandroidapp.features.auth.data.dto

data class AuthenticationResponseDto(
    val email: String,
    val token: String,
    val roles: Set<String>
)