package com.pratik.catchywall.data.remote

import com.pratik.catchywall.data.model.CollectionResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {

    companion object {

        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = "Us7xh31OYm-8Ow-rRdFQsqKNApT9aQ85tDHKsDVXa34"

    }

    @GET("collections")
    suspend fun getCollectionList(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int = 15,
        @Query("client_id") clientId: String = CLIENT_ID
    ): CollectionResponseModel

}