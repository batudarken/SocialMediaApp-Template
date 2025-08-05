package com.example.socialmediaapp.domain.repository

import com.example.socialmediaapp.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<User>
    suspend fun register(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Result<User>
    suspend fun verifyEmail(email: String, code: String): Result<Boolean>
    suspend fun resendVerificationCode(email: String): Result<Boolean>
    suspend fun forgotPassword(email: String): Result<Boolean>
    suspend fun logout(): Result<Boolean>
    suspend fun getCurrentUser(): User?
    suspend fun isLoggedIn(): Boolean
}

