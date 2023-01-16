package com.pratik.catchywall.data.model

data class UserProfileCollectionsModelItem(
    val id: String? = "",
    val title: String? = "",
    val links: Links,
    val user: User,
    val cover_photo: CoverPhoto,
    val preview_photos: List<PreviewPhoto>
)
