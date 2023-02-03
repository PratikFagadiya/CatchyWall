package com.pratik.catchywall.presentation.callbacks

import com.pratik.catchywall.data.model.Urls
import com.pratik.catchywall.data.model.User

interface SinglePhotoWallpaperClickListener {
    fun homeWallpaperClick(
        urls: Urls,
        user: User, id: String
    )
}