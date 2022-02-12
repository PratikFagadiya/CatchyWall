package com.pratik.catchywall.data.remote.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pratik.catchywall.data.model.UserProfilePhotosModelItem
import com.pratik.catchywall.data.remote.NetworkApi

private const val STARTING_PAGE_INDEX = 1

class UserProfilePhotosPagingSource(
    private val networkApi: NetworkApi,
    private val userName: String
) :
    PagingSource<Int, UserProfilePhotosModelItem>() {

    override fun getRefreshKey(state: PagingState<Int, UserProfilePhotosModelItem>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserProfilePhotosModelItem> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {

            val response = networkApi.getUserProfilePhotos(
                username = userName,
                page = position,
                per_page = params.loadSize
            )

            LoadResult.Page(
                data = response,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (response.isEmpty()) null else position + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }

    }
}