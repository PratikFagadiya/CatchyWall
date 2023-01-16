package com.pratik.catchywall.presentation.callbacks

import com.pratik.catchywall.data.model.Urls
import com.pratik.catchywall.data.model.User

interface HomeWallpaperClickListener {
    fun homeWallpaperClick(
        urls: Urls,
        user: User, id: String, name: String
    )
}