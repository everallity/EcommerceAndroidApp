package com.everallity.ecommerceandroidapp.features.auth.presentation

sealed class AuthEvent {
    object NavigateToHome: AuthEvent()
    data class ShowMessage(val message: String): AuthEvent()
}