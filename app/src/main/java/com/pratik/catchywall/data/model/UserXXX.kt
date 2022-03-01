package com.pratik.catchywall.data.model

import java.io.Serializable

data class UserXXX(
    val accepted_tos: Boolean,
    val bio: String,
    val first_name: String,
    val for_hire: Boolean,
    val id: String,
    val instagram_username: String,
    val last_name: String,
    val links: LinksXXXXXXXX,
    val location: String,
    val name: String,
    val portfolio_url: String,
    val profile_image: ProfileImageXXXX,
    val social: SocialXXXX,
    val total_collections: Int,
    val total_likes: Int,
    val total_photos: Int,
    val twitter_username: String,
    val updated_at: String,
    val username: String
): Serializable