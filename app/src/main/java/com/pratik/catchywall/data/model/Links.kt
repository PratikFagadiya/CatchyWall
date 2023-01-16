package com.pratik.catchywall.data.model

data class Links(
    val download: String? = "",
    val download_location: String? = "",
    val html: String? = "",
    val self: String? = "",
    val followers: String? = "",
    val following: String? = "",
    val likes: String? = "",
    val photos: String? = "",
    val portfolio: String? = ""
) : java.io.Serializable