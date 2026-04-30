package com.everallity.ecommerceandroidapp.features.auth.entity

data class Account(
    val accountId: Int,
    val username: String,
    val email: String,
    val password: String,
    val type: String
)
