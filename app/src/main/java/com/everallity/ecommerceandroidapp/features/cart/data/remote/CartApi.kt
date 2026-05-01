package com.everallity.ecommerceandroidapp.features.cart.data.remote

import com.everallity.ecommerceandroidapp.features.cart.data.dto.CartDto
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface CartApi {
    @Multipart
    @POST("cart/additemtocart")
    suspend fun addItem(
        @Part("id") accountId: Int,
        @Part("product_id") productId: Int
    ): Boolean

    @Multipart
    @POST("cart/getcartofclient")
    suspend fun getCart(
        @Part("id") accountId: Long,
    ): CartDto

    @Multipart
    @POST("cart/decreasecartitem")
    suspend fun decreaseCartItem(
        @Part("cart_id") cartId: Int,
        @Part("quantity") quantity: Int,
        @Part("id") id: Int, // This is the CartItem's own ID
        @Part("product_id") productId: Int,
        @Part("totalamount") totalAmount: Double
    ): Boolean

    @FormUrlEncoded
    @POST("cart/increasecartitem")
    suspend fun increaseCartItem(
        @Field("cart_id") cartId: Int,
        @Field("quantity") quantity: Int,
        @Field("id") id: Int,
        @Field("product_id") productId: Int,
        @Field("totalamount") totalAmount: Double
    ): Boolean

    @FormUrlEncoded
    @POST("cart/deletecartitem")
    suspend fun deleteCartItem(
        @Field("cart_id") cartId: Int,
        @Field("quantity") quantity: Int,
        @Field("id") id: Int,
        @Field("product_id") productId: Int,
        @Field("totalamount") totalAmount: Double
    ): Boolean
}