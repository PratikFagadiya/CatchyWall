package com.pratik.catchywall.data.remote

import com.pratik.catchywall.data.model.CollectionResponseModelItem
import com.pratik.catchywall.data.model.HomeResponseModelItem
import retrofit2.Call
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
        @Query("per_page") per_page: Int,
        @Query("client_id") clientId: String = CLIENT_ID
    ): List<CollectionResponseModelItem>

    @GET("photos")
    suspend fun getHomePhotosList(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int = 15,
        @Query("client_id") clientId: String = CLIENT_ID
    ): List<HomeResponseModelItem>

}