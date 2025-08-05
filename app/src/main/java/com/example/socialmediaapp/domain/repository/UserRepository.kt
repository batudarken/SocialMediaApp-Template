package com.example.socialmediaapp.domain.repository

import com.example.socialmediaapp.domain.model.User

interface UserRepository {
    suspend fun getUser(userId: String): Result<User>
    suspend fun updateProfile(
        firstName: String,
        lastName: String,
        bio: String?,
        profileImageUrl: String?
    ): Result<User>
    suspend fun followUser(userId: String): Result<Boolean>
    suspend fun unfollowUser(userId: String): Result<Boolean>
    suspend fun getFollowers(userId: String, page: Int, limit: Int): Result<List<User>>
    suspend fun getFollowing(userId: String, page: Int, limit: Int): Result<List<User>>
    suspend fun searchUsers(query: String, page: Int, limit: Int): Result<List<User>>
    suspend fun isFollowing(userId: String): Result<Boolean>
}

