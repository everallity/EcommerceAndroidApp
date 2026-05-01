package com.everallity.ecommerceandroidapp.features.auth.domain.entity

data class Account(
    val accountId: Long,
    val email: String,
    val password: String,
    val role: Set<String>
)
