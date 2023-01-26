package com.pratik.catchywall.data.remote.repository

import com.pratik.catchywall.data.model.PhotoDetailResponse
import com.pratik.catchywall.data.remote.NetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PhotoRepository @Inject constructor(private val networkApi: NetworkApi) {

    suspend fun getPhotoDetail(id: String): Flow<PhotoDetailResponse> = flow {
        emit(networkApi.getPhotoDetail(id))
    }.flowOn(Dispatchers.IO)

}