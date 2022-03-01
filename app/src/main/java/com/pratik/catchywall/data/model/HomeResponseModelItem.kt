package com.pratik.catchywall.data.model

data class HomeResponseModelItem(
    val alt_description: String,
    val blur_hash: String,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: LinksXXXXXX,
    val promoted_at: String,
    val sponsorship: Sponsorship,
    val updated_at: String,
    val urls: UrlsXXX,
    val user: UserXXX,
    val width: Int
)