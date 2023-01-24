package com.pratik.catchywall.data.remote.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pratik.catchywall.data.model.SearchCollectionResultResponseModel
import com.pratik.catchywall.data.remote.NetworkApi
import timber.log.Timber

private const val STARTING_PAGE_INDEX = 1

class SearchCollectionListPagingSource(val networkApi: NetworkApi, private val searchQuery: String) :
    PagingSource<Int, SearchCollectionResultResponseModel>() {

    override fun getRefreshKey(state: PagingState<Int, SearchCollectionResultResponseModel>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchCollectionResultResponseModel> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = networkApi.getSearchCollectionList(page = position, searchQuery).results

            Timber.d("Search Photo ${response.size}")

            LoadResult.Page(
                data = response,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (response.isEmpty()) null else position + 1
            )
        } catch (e: java.lang.Exception) {
            LoadResult.Error(e)
        }
    }
}