package com.everallity.ecommerceandroidapp.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.everallity.ecommerceandroidapp.features.auth.domain.usecase.GetAuthStateUseCase
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
    private val getAuthStateUseCase: GetAuthStateUseCase
): ViewModel() {


    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadCart()
    }

    fun loadCart() {
        viewModelScope.launch {

        }
    }

    fun checkAuthenticationStatus() {
        viewModelScope.launch {
            val isAuthenticated = getAuthStateUseCase()
            if (isAuthenticated == true) {
                _uiState.update { it.copy(
                    isLoggedIn = true
                ) }
            }
        }
    }



}