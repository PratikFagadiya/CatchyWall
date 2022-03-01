package com.pratik.catchywall.data.remote

import com.pratik.catchywall.Sensitive
import com.pratik.catchywall.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface
NetworkApi {

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = Sensitive.CLIENT_ID
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
        @Query("per_page") per_page: Int,
        @Query("client_id") clientId: String = CLIENT_ID
    ): List<HomeResponseModelItem>

    @GET("users/{username}/photos")
    suspend fun getUserProfilePhotos(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
        @Query("client_id") clientId: String = CLIENT_ID
    ): List<UserProfilePhotosModelItem>

    @GET("users/{username}/likes")
    suspend fun getUserProfileLikes(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
        @Query("client_id") clientId: String = CLIENT_ID
    ): List<UserProfileLikesModelItem>

    @GET("users/{username}/collections")
    suspend fun getUserProfileCollections(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
        @Query("client_id") clientId: String = CLIENT_ID
    ): List<UserProfileCollectionsModelItem>

    @GET("collections/{id}/photos")
    suspend fun getCollectionWallpaperList(
        @Path("id") id: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
        @Query("client_id") clientId: String = CLIENT_ID
    ): List<CollectionWallpaperListModelItem>

}