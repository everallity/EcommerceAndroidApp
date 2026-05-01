package com.everallity.ecommerceandroidapp.features.auth.data.mapper

import com.everallity.ecommerceandroidapp.features.auth.data.dto.AccountResponseDto
import com.everallity.ecommerceandroidapp.features.auth.domain.entity.Account

fun AccountResponseDto.toDomain(): Account {
    return Account(
        this.id,
        this.email,
        this.password,
        this.roles
    )
}