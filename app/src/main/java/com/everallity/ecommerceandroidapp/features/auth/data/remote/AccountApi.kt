package com.everallity.ecommerceandroidapp.features.auth.data.remote

import com.everallity.ecommerceandroidapp.features.auth.data.dto.AccountResponseDto
import com.everallity.ecommerceandroidapp.features.auth.data.dto.ApiResponse
import retrofit2.http.GET

interface AccountApi {
    @GET("accounts/me")
    suspend fun getOwnAccount(): ApiResponse<AccountResponseDto>
}