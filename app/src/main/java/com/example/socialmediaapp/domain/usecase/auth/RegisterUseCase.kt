package com.example.socialmediaapp.domain.usecase.auth

import com.example.socialmediaapp.domain.model.User
import com.example.socialmediaapp.domain.repository.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Result<User> {
        
        if (firstName.isBlank()) {
            return Result.failure(Exception("Ad boş olamaz"))
        }
        
        if (lastName.isBlank()) {
            return Result.failure(Exception("Soyad boş olamaz"))
        }
        
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
        
        if (password != confirmPassword) {
            return Result.failure(Exception("Şifreler eşleşmiyor"))
        }
        
        return authRepository.register(firstName, lastName, email, password)
    }
    
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}

