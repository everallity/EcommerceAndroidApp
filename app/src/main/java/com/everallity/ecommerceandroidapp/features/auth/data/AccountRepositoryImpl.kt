package com.everallity.ecommerceandroidapp.features.auth.data

import com.everallity.ecommerceandroidapp.features.auth.data.mapper.toDomain
import com.everallity.ecommerceandroidapp.features.auth.data.remote.AccountApi
import com.everallity.ecommerceandroidapp.features.auth.domain.entity.Account
import com.everallity.ecommerceandroidapp.features.auth.domain.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val api: AccountApi
) : AccountRepository {
    override suspend fun getOwnAccount(): Result<Account> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getOwnAccount()
                if (response.success && response.data != null) {
                    Result.success(
                        response.data.toDomain()
                    )
                } else
                    Result.failure(Exception(response.message))
            } catch (e: Exception) {
                Result.failure(Exception(e))
            }
        }
    }

}