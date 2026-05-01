package com.everallity.ecommerceandroidapp.core.data

import com.everallity.ecommerceandroidapp.features.auth.data.AuthenticationRepositoryImpl
import com.everallity.ecommerceandroidapp.features.auth.domain.repository.AuthenticationRepository
import com.everallity.ecommerceandroidapp.features.cart.data.CartRepositoryImpl
import com.everallity.ecommerceandroidapp.features.cart.domain.repository.CartRepository
import com.everallity.ecommerceandroidapp.features.catalog.data.ProductRepositoryImpl
import com.everallity.ecommerceandroidapp.features.catalog.domain.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository

    @Binds
    @Singleton
    abstract fun bindCartRepository(
        cartRepositoryImpl: CartRepositoryImpl
    ): CartRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authenticationRepositoryImpl: AuthenticationRepositoryImpl
    ): AuthenticationRepository
}