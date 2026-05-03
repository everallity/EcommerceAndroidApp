package com.everallity.ecommerceandroidapp.features.auth.domain.repository

import com.everallity.ecommerceandroidapp.features.auth.domain.entity.Account

interface AccountRepository {
    suspend fun getOwnAccount(): Result<Account>
}