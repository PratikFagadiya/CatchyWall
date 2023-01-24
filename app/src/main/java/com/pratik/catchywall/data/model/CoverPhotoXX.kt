package com.pratik.catchywall.data.model

data class CoverPhotoXX(
    val blur_hash: String,
    val color: String,
    val created_at: String,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: LinksXXX,
    val urls: UrlsXX,
    val user: UserXX,
    val width: Int
)