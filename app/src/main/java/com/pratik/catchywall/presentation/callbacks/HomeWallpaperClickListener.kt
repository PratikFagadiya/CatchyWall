package com.pratik.catchywall.presentation.callbacks

import com.pratik.catchywall.data.model.UrlsXXX
import com.pratik.catchywall.data.model.UserXXX

interface HomeWallpaperClickListener {

    fun homeWallpaperClick(
        urls: UrlsXXX,
        user: UserXXX, id: String, name: String
    )

}