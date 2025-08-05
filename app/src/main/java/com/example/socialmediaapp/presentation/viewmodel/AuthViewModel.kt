package com.example.socialmediaapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialmediaapp.domain.model.User
import com.example.socialmediaapp.domain.usecase.auth.LoginUseCase
import com.example.socialmediaapp.domain.usecase.auth.RegisterUseCase
import com.example.socialmediaapp.domain.usecase.auth.VerifyEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase,
    private val verifyEmailUseCase: VerifyEmailUseCase
) : ViewModel() {

    private val _loginState = MutableStateFlow<AuthResult>(AuthResult.Idle)
    val loginState: StateFlow<AuthResult> = _loginState

    private val _registerState = MutableStateFlow<AuthResult>(AuthResult.Idle)
    val registerState: StateFlow<AuthResult> = _registerState

    private val _verifyEmailState = MutableStateFlow<AuthResult>(AuthResult.Idle)
    val verifyEmailState: StateFlow<AuthResult> = _verifyEmailState

    fun login(email: String, password: String) {
        _loginState.value = AuthResult.Loading
        viewModelScope.launch {
            loginUseCase(email, password)
                .onSuccess { user ->
                    _loginState.value = AuthResult.Success(user)
                }
                .onFailure { exception ->
                    _loginState.value = AuthResult.Error(exception.message ?: "Bilinmeyen bir hata oluştu")
                }
        }
    }

    fun register(firstName: String, lastName: String, email: String, password: String, confirmPassword: String) {
        _registerState.value = AuthResult.Loading
        viewModelScope.launch {
            registerUseCase(firstName, lastName, email, password, confirmPassword)
                .onSuccess { user ->
                    _registerState.value = AuthResult.Success(user)
                }
                .onFailure { exception ->
                    _registerState.value = AuthResult.Error(exception.message ?: "Bilinmeyen bir hata oluştu")
                }
        }
    }

    fun verifyEmail(email: String, code: String) {
        _verifyEmailState.value = AuthResult.Loading
        viewModelScope.launch {
            verifyEmailUseCase(email, code)
                .onSuccess { isVerified ->
                    if (isVerified) {
                        _verifyEmailState.value = AuthResult.Success(null) // User object not needed for verification success
                    } else {
                        _verifyEmailState.value = AuthResult.Error("Doğrulama başarısız oldu")
                    }
                }
                .onFailure { exception ->
                    _verifyEmailState.value = AuthResult.Error(exception.message ?: "Bilinmeyen bir hata oluştu")
                }
        }
    }

    sealed class AuthResult {
        object Idle : AuthResult()
        object Loading : AuthResult()
        data class Success(val user: User?) : AuthResult()
        data class Error(val message: String) : AuthResult()
    }
}

