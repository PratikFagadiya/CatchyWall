package com.pratik.catchywall.data.remote.repository

import androidx.paging.*
import com.pratik.catchywall.data.model.UserProfileCollectionsModelItem
import com.pratik.catchywall.data.model.UserProfileLikesModelItem
import com.pratik.catchywall.data.model.UserProfilePhotosModelItem
import com.pratik.catchywall.data.remote.NetworkApi
import com.pratik.catchywall.data.remote.pagingsources.UserProfileCollectionsPagingSource
import com.pratik.catchywall.data.remote.pagingsources.UserProfileLikesPagingSource
import com.pratik.catchywall.data.remote.pagingsources.UserProfilePhotosPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserProfileRepository @Inject constructor(private val networkApi: NetworkApi) {

    fun getUserProfilePhotos(userName: String): Flow<PagingData<UserProfilePhotosModelItem>> {
        return Pager(
            config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
            pagingSourceFactory = { UserProfilePhotosPagingSource(networkApi, userName) }
        ).flow
    }

    fun getUserProfileLikes(userName: String): Flow<PagingData<UserProfileLikesModelItem>> {
        return Pager(
            config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
            pagingSourceFactory = { UserProfileLikesPagingSource(networkApi, userName) }
        ).flow
    }

    fun getUserProfileCollections(userName: String): Flow<PagingData<UserProfileCollectionsModelItem>> {
        return Pager(
            config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
            pagingSourceFactory = { UserProfileCollectionsPagingSource(networkApi, userName) }
        ).flow
    }


}