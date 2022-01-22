package com.pratik.catchywall.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.pratik.catchywall.data.remote.NetworkApi
import com.pratik.catchywall.data.remote.pagingsources.CollectionPagingSource
import javax.inject.Inject


class HomeRepository @Inject constructor(private val networkApi: NetworkApi) {

//    fun getHomePicsList() = Pager(
//        config = PagingConfig(
//            pageSize = 20,
//            maxSize = 100,
//            enablePlaceholders = false
//        ),
//        pagingSourceFactory = { CollectionPagingSource() }
//    ).liveData


}