package com.example.socialmediaapp.domain.model

data class Post(
    val id: String,
    val userId: String,
    val content: String? = null,
    val imageUrls: List<String> = emptyList(),
    val videoUrl: String? = null,
    val likesCount: Int = 0,
    val commentsCount: Int = 0,
    val sharesCount: Int = 0,
    val isLiked: Boolean = false,
    val isSaved: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val user: User? = null
)

enum class PostType {
    TEXT,
    IMAGE,
    VIDEO,
    MIXED
}

