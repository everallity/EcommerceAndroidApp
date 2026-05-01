package com.everallity.ecommerceandroidapp.features.auth.domain.usecase

import com.everallity.ecommerceandroidapp.features.auth.domain.entity.AuthToken
import com.everallity.ecommerceandroidapp.features.auth.domain.repository.AuthenticationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<AuthToken> {
        return authenticationRepository.login(email, password)
    }
}