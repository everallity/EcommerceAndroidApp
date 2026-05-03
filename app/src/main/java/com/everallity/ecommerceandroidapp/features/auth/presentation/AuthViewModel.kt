package com.everallity.ecommerceandroidapp.features.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.everallity.ecommerceandroidapp.features.auth.domain.usecase.LoginUseCase
import com.everallity.ecommerceandroidapp.features.auth.domain.usecase.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val signupUseCase: SignUpUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    private val _authEvent = MutableSharedFlow<AuthEvent>()
    val authEvent = _authEvent.asSharedFlow()
    fun onEmailChanged(value: String) {
        _uiState.update { it.copy(email = value, error = null) }
    }

    fun onPasswordChanged(value: String) {
        _uiState.update { it.copy(password = value, error = null) }
    }

    fun onLoginClick() {
        _uiState.update { it.copy(isSigningIn = true, error = null) }
        val currentState = uiState.value
        val email = currentState.email
        val password = currentState.password
        viewModelScope.launch {
            val result = loginUseCase(email, password)
            result.onSuccess {
                _uiState.update { it.copy(isSigningIn = false) }
                _authEvent.emit(AuthEvent.NavigateToHome)
            }.onFailure { throwable ->
                val message = throwable.message ?: "Something went wrong"
                _uiState.update { it.copy(isSigningIn = false, error = message) }
            }
        }
    }

    fun onSignupClick() {
        _uiState.update { it.copy(isSigningUp = true, error = null) }
        val currentState = uiState.value
        val email = currentState.email
        val password = currentState.password
        viewModelScope.launch {
            val result = signupUseCase(email, password)
            result.onSuccess {
                _uiState.update { it.copy(isSigningUp = false, error = null) }
                _authEvent.emit(AuthEvent.ShowToast("Sign up success"))
            }.onFailure { throwable ->
                _uiState.update { it.copy(isSigningUp = false, error = throwable.message) }
            }
        }
    }
}