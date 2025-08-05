package com.example.socialmediaapp.domain.usecase.auth

import com.example.socialmediaapp.domain.model.User
import com.example.socialmediaapp.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<User> {
        if (email.isBlank()) {
            return Result.failure(Exception("E-posta adresi boş olamaz"))
        }
        
        if (!isValidEmail(email)) {
            return Result.failure(Exception("Geçerli bir e-posta adresi girin"))
        }
        
        if (password.isBlank()) {
            return Result.failure(Exception("Şifre boş olamaz"))
        }
        
        if (password.length < 6) {
            return Result.failure(Exception("Şifre en az 6 karakter olmalıdır"))
        }
        
        return authRepository.login(email, password)
    }
    
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}

