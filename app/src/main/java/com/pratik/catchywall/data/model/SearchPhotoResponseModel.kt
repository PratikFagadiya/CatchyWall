package com.pratik.catchywall.data.model

data class SearchPhotoResponseModel(
    val results: List<HomeResponseModelItem>,
    val total: Int,
    val total_pages: Int
)