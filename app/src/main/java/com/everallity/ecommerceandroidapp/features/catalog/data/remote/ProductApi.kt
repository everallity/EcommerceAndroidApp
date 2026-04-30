package com.everallity.ecommerceandroidapp.features.catalog.data.remote

import com.everallity.ecommerceandroidapp.features.catalog.data.ProductDto
import retrofit2.http.GET

interface ProductApi {
    @GET("product/getlistproduct")
    suspend fun getProducts(): List<ProductDto>
}