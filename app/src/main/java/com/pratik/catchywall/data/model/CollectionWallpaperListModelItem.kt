package com.pratik.catchywall.data.model

data class CollectionWallpaperListModelItem(
    val id: String,
    val width: Int = 0,
    val height: Int = 0,
    val color: String,
    val urls: UrlsXXX,
    val likes: Int,
    val user: UserXXX
)