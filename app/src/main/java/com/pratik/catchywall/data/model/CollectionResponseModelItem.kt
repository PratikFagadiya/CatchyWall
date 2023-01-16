package com.pratik.catchywall.data.model

data class CollectionResponseModelItem(
    val cover_photo: CoverPhoto,
    val description: String,
    val featured: Boolean,
    val id: String,
    val preview_photos: List<PreviewPhoto>,
    val tags: List<Tag>,
    val title: String,
    val total_photos: Int,
    val user: User
)