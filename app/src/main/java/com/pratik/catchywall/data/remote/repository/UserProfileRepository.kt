package com.pratik.catchywall.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.pratik.catchywall.data.remote.NetworkApi
import com.pratik.catchywall.data.remote.pagingsources.UserProfileCollectionsPagingSource
import com.pratik.catchywall.data.remote.pagingsources.UserProfileLikesPagingSource
import com.pratik.catchywall.data.remote.pagingsources.UserProfilePhotosPagingSource
import javax.inject.Inject

class UserProfileRepository @Inject constructor(private val networkApi: NetworkApi) {

    fun getUserProfilePhotos(userName: String) = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
        pagingSourceFactory = { UserProfilePhotosPagingSource(networkApi, userName) }
    ).liveData


    fun getUserProfileLikes(userName: String) = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
        pagingSourceFactory = { UserProfileLikesPagingSource(networkApi, userName) }
    ).liveData

    fun getUserProfileCollections(userName: String) = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
        pagingSourceFactory = { UserProfileCollectionsPagingSource(networkApi, userName) }
    ).liveData


}