package com.everallity.ecommerceandroidapp.features.auth.domain.usecase

import com.everallity.ecommerceandroidapp.features.auth.domain.repository.AuthenticationRepository
import javax.inject.Inject

class GetAuthStateUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {
    suspend operator fun invoke(): Boolean {
        return repository.isAuthenticated()
    }
}