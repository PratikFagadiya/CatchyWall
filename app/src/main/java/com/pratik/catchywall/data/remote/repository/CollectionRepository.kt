package com.pratik.catchywall.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.pratik.catchywall.data.model.CollectionResponseModelItem
import com.pratik.catchywall.data.remote.NetworkApi
import com.pratik.catchywall.data.remote.pagingsources.CollectionPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CollectionRepository
@Inject constructor(private val networkApi: NetworkApi) {

    fun getCollectionList(): Flow<PagingData<CollectionResponseModelItem>> {
        return Pager(
            config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
            pagingSourceFactory = { CollectionPagingSource(networkApi) }
        ).flow

    }

}