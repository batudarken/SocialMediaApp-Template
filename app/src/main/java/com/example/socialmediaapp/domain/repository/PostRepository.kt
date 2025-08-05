package com.example.socialmediaapp.domain.repository

import com.example.socialmediaapp.domain.model.Post

interface PostRepository {
    suspend fun getFeedPosts(page: Int, limit: Int): Result<List<Post>>
    suspend fun getUserPosts(userId: String, page: Int, limit: Int): Result<List<Post>>
    suspend fun getPost(postId: String): Result<Post>
    suspend fun createPost(
        content: String?,
        imageUrls: List<String>,
        videoUrl: String?
    ): Result<Post>
    suspend fun likePost(postId: String): Result<Boolean>
    suspend fun unlikePost(postId: String): Result<Boolean>
    suspend fun savePost(postId: String): Result<Boolean>
    suspend fun unsavePost(postId: String): Result<Boolean>
    suspend fun deletePost(postId: String): Result<Boolean>
    suspend fun getSavedPosts(page: Int, limit: Int): Result<List<Post>>
}

