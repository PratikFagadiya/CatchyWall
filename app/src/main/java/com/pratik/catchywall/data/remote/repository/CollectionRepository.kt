package com.pratik.catchywall.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pratik.catchywall.data.model.CollectionResponseModelItem
import com.pratik.catchywall.data.model.CollectionWallpaperListModelItem
import com.pratik.catchywall.data.remote.NetworkApi
import com.pratik.catchywall.data.remote.pagingsources.CollectionPagingSource
import com.pratik.catchywall.data.remote.pagingsources.CollectionWallpaperListPagingSource
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

    fun getCollectionWallpaperList(collectionId: String): Flow<PagingData<CollectionWallpaperListModelItem>> {

        return Pager(
            config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
            pagingSourceFactory = {
                CollectionWallpaperListPagingSource(
                    networkApi,
                    collectionId = collectionId
                )
            }
        ).flow

    }

}