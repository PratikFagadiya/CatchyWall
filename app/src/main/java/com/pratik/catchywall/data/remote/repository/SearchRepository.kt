package com.pratik.catchywall.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pratik.catchywall.data.model.HomeResponseModelItem
import com.pratik.catchywall.data.remote.NetworkApi
import com.pratik.catchywall.data.remote.pagingsources.SearchPhotoListPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepository @Inject constructor(private val networkApi: NetworkApi) {

    fun getSearchPhotosList(query: String): Flow<PagingData<HomeResponseModelItem>> {
        return Pager(
            config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
            pagingSourceFactory = {
                SearchPhotoListPagingSource(networkApi, query)
            }
        ).flow
    }

}