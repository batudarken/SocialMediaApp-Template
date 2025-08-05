package com.example.socialmediaapp.domain.model

data class Story(
    val id: String,
    val userId: String,
    val imageUrl: String? = null,
    val videoUrl: String? = null,
    val duration: Long = 15000, // 15 seconds default
    val isViewed: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val expiresAt: Long = System.currentTimeMillis() + 24 * 60 * 60 * 1000, // 24 hours
    val user: User? = null
)

enum class StoryType {
    IMAGE,
    VIDEO
}

