package com.everallity.ecommerceandroidapp.features.auth.domain.repository

import com.everallity.ecommerceandroidapp.features.auth.domain.entity.AuthToken
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {
    suspend fun login(email: String, password: String): Result<AuthToken>
    suspend fun signup(email: String, password: String): Result<AuthToken>
    suspend fun logout()

    suspend fun isAuthenticated(): Boolean
}