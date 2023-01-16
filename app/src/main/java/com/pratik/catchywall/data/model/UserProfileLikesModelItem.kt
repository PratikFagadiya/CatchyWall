package com.pratik.catchywall.data.model

data class UserProfileLikesModelItem(
    val id: String? = "",
    val width: Long = 0L,
    val height: Long = 0L,
    val color: String = "",
    val urls: Urls,
    val links: Links,
    val categories: List<Any>,
    val likes: Int = 0,
    val user: User
)
