package com.pratik.catchywall.data.remote.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pratik.catchywall.data.model.HomeResponseModelItem
import com.pratik.catchywall.data.remote.NetworkApi

private const val STARTING_PAGE_INDEX = 1

class HomePagingSource(private val networkApi: NetworkApi) :

    PagingSource<Int, HomeResponseModelItem>() {

    override fun getRefreshKey(state: PagingState<Int, HomeResponseModelItem>): Int? {

        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeResponseModelItem> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = networkApi.getHomePhotosList(position, per_page = params.loadSize)

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