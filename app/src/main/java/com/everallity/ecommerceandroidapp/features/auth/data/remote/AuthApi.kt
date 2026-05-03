package com.everallity.ecommerceandroidapp.features.auth.data.remote

import com.everallity.ecommerceandroidapp.features.auth.data.dto.AccountRequestDto
import com.everallity.ecommerceandroidapp.features.auth.data.dto.AccountResponseDto
import com.everallity.ecommerceandroidapp.features.auth.data.dto.ApiResponse
import com.everallity.ecommerceandroidapp.features.auth.data.dto.AuthenticationRequestDto
import com.everallity.ecommerceandroidapp.features.auth.data.dto.AuthenticationResponseDto
import com.everallity.ecommerceandroidapp.features.auth.data.dto.TokenValidateRequestDto
import com.everallity.ecommerceandroidapp.features.auth.data.dto.TokenValidateResponseDto
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.Objects

interface AuthApi {
    @POST("auth/signup")
    suspend fun signup(@Body authenticationRequestDto: AuthenticationRequestDto): ApiResponse<AuthenticationResponseDto>

    @POST("auth/login")
    suspend fun login(@Body authenticationRequestDto: AuthenticationRequestDto): ApiResponse<AuthenticationResponseDto>

    @POST("auth/logout")
    suspend fun logout(@Body authenticationRequestDto: AuthenticationRequestDto): ApiResponse<Objects>

    @POST("auth/introspect")
    suspend fun tokenValidate(@Body tokenValidateRequestDto: TokenValidateRequestDto): ApiResponse<TokenValidateResponseDto>
}