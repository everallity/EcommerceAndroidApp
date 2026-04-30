package com.everallity.ecommerceandroidapp.core.network

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
}