package com.everallity.ecommerceandroidapp.features.catalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.everallity.ecommerceandroidapp.features.catalog.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CatalogState())
    val state = _state.asStateFlow()
    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            val result = getProductsUseCase()
            if (result.isEmpty()) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = "No products found"
                )
            } else {
                _state.value = _state.value.copy(
                    isLoading = false,
                    productList = result
                )
            }
        }
    }
}