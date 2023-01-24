package com.pratik.catchywall.data.model

data class SearchUserResponseModel(
    val results: List<User>,
    val total: Int,
    val total_pages: Int
)