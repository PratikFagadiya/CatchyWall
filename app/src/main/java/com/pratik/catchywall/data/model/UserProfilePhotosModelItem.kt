package com.pratik.catchywall.data.model

data class UserProfilePhotosModelItem(
    val id: String? = "",
    val width: Long = 0L,
    val height: Long = 0L,
    val color: String = "",
    val urls: UrlsXXX,
    val links: LinksXXXXXX,
    val categories: List<Any>,
    val likes: Int = 0,
    val user: UserXXX
)
