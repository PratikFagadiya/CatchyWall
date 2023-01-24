package com.pratik.catchywall.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pratik.catchywall.data.model.HomeResponseModelItem
import com.pratik.catchywall.data.model.SearchCollectionResultResponseModel
import com.pratik.catchywall.data.model.SearchUserResponseModel
import com.pratik.catchywall.data.model.User
import com.pratik.catchywall.data.remote.NetworkApi
import com.pratik.catchywall.data.remote.pagingsources.SearchCollectionListPagingSource
import com.pratik.catchywall.data.remote.pagingsources.SearchPhotoListPagingSource
import com.pratik.catchywall.data.remote.pagingsources.SearchUserListPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepository @Inject constructor(private val networkApi: NetworkApi) {

    fun getSearchPhotosList(query: String): Flow<PagingData<HomeResponseModelItem>> {
        return Pager(config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = false
        ),
            pagingSourceFactory = {
                SearchPhotoListPagingSource(networkApi, query)
            }).flow
    }

    fun getSearchUserList(query: String): Flow<PagingData<User>> {
        return Pager(config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = false
        ),
            pagingSourceFactory = {
                SearchUserListPagingSource(networkApi, query)
            }).flow
    }

    fun getSearchCollectionList(query: String): Flow<PagingData<SearchCollectionResultResponseModel>> {
        return Pager(config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = false
        ),
            pagingSourceFactory = {
                SearchCollectionListPagingSource(networkApi, query)
            }).flow
    }

}