package com.everallity.ecommerceandroidapp.features.auth.domain.entity

data class AuthToken(
    val token: String,
    val email: String,
    val roles: Set<String>
)