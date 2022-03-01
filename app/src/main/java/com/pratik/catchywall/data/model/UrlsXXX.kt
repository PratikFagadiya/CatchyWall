package com.pratik.catchywall.data.model

import java.io.Serializable

data class UrlsXXX(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String,
    val small_s3: String? = "",
) : Serializable