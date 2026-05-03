package com.everallity.ecommerceandroidapp.features.auth.data.dto

data class AuthenticationResponseDto(
    val userId: Long,
    val email: String,
    val token: String,
    val roles: Set<String>
)