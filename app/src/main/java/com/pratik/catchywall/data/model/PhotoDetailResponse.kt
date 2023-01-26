package com.pratik.catchywall.data.model

data class PhotoDetailResponse(
    val blur_hash: String,
    val color: String,
    val created_at: String,
    val description: String,
    val downloads: Int,
    val exif: Exif,
    val height: Int,
    val id: String,
    val likes: Int,
    val links: Links,
    val location: Location,
    val public_domain: Boolean,
    val tags: List<TagX>,
    val updated_at: String,
    val urls: Urls,
    val user: User,
    val width: Int
)