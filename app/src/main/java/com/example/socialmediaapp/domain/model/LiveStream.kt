package com.example.socialmediaapp.domain.model

data class LiveStream(
    val id: String,
    val userId: String,
    val title: String,
    val description: String? = null,
    val thumbnailUrl: String? = null,
    val streamUrl: String? = null,
    val viewersCount: Int = 0,
    val isActive: Boolean = false,
    val startedAt: Long? = null,
    val endedAt: Long? = null,
    val user: User? = null
)

data class LiveComment(
    val id: String,
    val streamId: String,
    val userId: String,
    val content: String,
    val createdAt: Long = System.currentTimeMillis(),
    val user: User? = null
)

