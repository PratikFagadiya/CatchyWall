package com.pratik.catchywall.data.model

data class SearchCollectionResultResponseModel(
    val cover_photo: CoverPhotoXX,
    val description: Any,
    val featured: Boolean,
    val id: Int,
    val last_collected_at: String,
    val links: LinksXXXXX,
    val `private`: Boolean,
    val published_at: String,
    val share_key: String,
    val title: String,
    val total_photos: Int,
    val updated_at: String,
    val user: UserXXX
)