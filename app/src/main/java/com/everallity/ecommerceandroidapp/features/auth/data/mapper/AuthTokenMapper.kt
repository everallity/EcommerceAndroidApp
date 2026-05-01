package com.everallity.ecommerceandroidapp.features.auth.data.mapper

import com.everallity.ecommerceandroidapp.features.auth.data.dto.AuthenticationResponseDto
import com.everallity.ecommerceandroidapp.features.auth.domain.entity.AuthToken

fun AuthenticationResponseDto.toDomain(): AuthToken {
    return AuthToken(
        this.token,
        this.email,
        this.roles
    )
}