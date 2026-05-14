package com.everallity.ecommerceandroidapp.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.everallity.ecommerceandroidapp.features.auth.domain.usecase.GetAuthStateUseCase
import com.everallity.ecommerceandroidapp.features.auth.domain.usecase.GetCurrentAccountUseCase
import com.everallity.ecommerceandroidapp.features.cart.domain.usecase.GetCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCartUseCase: GetCartUseCase,
    private val getAuthStateUseCase: GetAuthStateUseCase,
    private val getCurrentAccountUseCase: GetCurrentAccountUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    init {
        checkAuthenticationStatus()
        if (uiState.value.isLoggedIn) {
            loadOwnAccount()
            loadCart()
        }
    }

    fun loadCart() {

    }

    fun loadOwnAccount() {
        viewModelScope.launch {
            val result = getCurrentAccountUseCase()
            result.fold(
                onSuccess = { account ->
                    _uiState.update { it.copy(

                    ) }
                },
                onFailure = {

                }
            )
        }
    }

    fun checkAuthenticationStatus() {
        viewModelScope.launch {
            _uiState.update { it.copy(
                isCheckingAuth = true
            ) }
            val isAuthenticated = getAuthStateUseCase()
            if (isAuthenticated) {
                _uiState.update { it.copy(
                    isCheckingAuth = false,
                    isLoggedIn = true
                ) }
            } else {
                _uiState.update { it.copy(
                    isCheckingAuth = false,
                    isLoggedIn = false
                ) }
            }
        }
    }



}