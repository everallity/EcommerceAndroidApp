package com.everallity.ecommerceandroidapp.features.cart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.everallity.ecommerceandroidapp.features.cart.domain.usecase.GetCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartUseCase: GetCartUseCase
): ViewModel() {
    private val _state = MutableStateFlow(CartState())
    val state = _state.asStateFlow()

    init {

    }

    fun loadCart() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
        }
    }
}