package com.everallity.ecommerceandroidapp.features.auth.data.dto

import com.google.gson.annotations.SerializedName

data class AccountResponseDto(
    val id: Long,
    val email: String,
    val password: String,
    @SerializedName("roleSet") val roles: Set<String>
)