package com.everallity.ecommerceandroidapp.features.auth.domain.usecase

import com.everallity.ecommerceandroidapp.features.auth.domain.entity.Account
import com.everallity.ecommerceandroidapp.features.auth.domain.repository.AccountRepository
import javax.inject.Inject

class GetCurrentAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {
    suspend operator fun invoke(): Result<Account> {
        return repository.getOwnAccount()
    }
}