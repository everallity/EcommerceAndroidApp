package com.everallity.ecommerceandroidapp.features.auth.data

import com.everallity.ecommerceandroidapp.core.util.TokenManager
import com.everallity.ecommerceandroidapp.features.auth.data.dto.AccountRequestDto
import com.everallity.ecommerceandroidapp.features.auth.data.dto.AuthenticationRequestDto
import com.everallity.ecommerceandroidapp.features.auth.data.remote.AuthApi
import com.everallity.ecommerceandroidapp.features.auth.domain.entity.AuthToken
import com.everallity.ecommerceandroidapp.features.auth.domain.repository.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.security.spec.ECField
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val tokenManager: TokenManager
) : AuthenticationRepository {

    override suspend fun login(
        email: String,
        password: String
    ): Result<AuthToken> {
        return withContext(Dispatchers.IO) {
            try {
                val request = AuthenticationRequestDto(email, password)
                val response = api.login(request)
                if (response.success && response.data != null ) {
                    tokenManager.saveToken(response.data.token)
                    Result.success(
                        AuthToken(
                            response.data.token,
                            response.data.email,
                            response.data.roles
                        )
                    )
                } else {
                    Result.failure(Exception(response.message))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    override suspend fun signup(
        email: String,
        password: String
    ): Result<AuthToken> {
        return withContext(Dispatchers.IO) {
            try {
                val request = AuthenticationRequestDto(email, password)
                val response = api.signup(request)
                if (response.success && response.data != null) {
                    val data = response.data
                    Result.success(AuthToken(
                        data.token,
                        data.email,
                        data.roles
                    ))
                } else {
                    Result.failure(Exception(response.message))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }

}