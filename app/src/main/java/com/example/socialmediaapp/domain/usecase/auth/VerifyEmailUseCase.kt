package com.example.socialmediaapp.domain.usecase.auth

import com.example.socialmediaapp.domain.repository.AuthRepository
import javax.inject.Inject

class VerifyEmailUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, code: String): Result<Boolean> {
        if (email.isBlank()) {
            return Result.failure(Exception("E-posta adresi boş olamaz"))
        }
        
        if (code.isBlank()) {
            return Result.failure(Exception("Doğrulama kodu boş olamaz"))
        }
        
        if (code.length != 6) {
            return Result.failure(Exception("Doğrulama kodu 6 haneli olmalıdır"))
        }
        
        if (!code.all { it.isDigit() }) {
            return Result.failure(Exception("Doğrulama kodu sadece rakam içermelidir"))
        }
        
        return authRepository.verifyEmail(email, code)
    }
}

