package com.pratik.catchywall.data.model

data class SearchCollectionResponseModel(
    val results: List<SearchCollectionResultResponseModel>,
    val total: Int,
    val total_pages: Int
)