package com.everallity.ecommerceandroidapp.features.auth.data.dto

data class ApiResponse<T>(
    val success: Boolean,
    val message: String?,
    val errorCode: Int,
    val data: T?
)