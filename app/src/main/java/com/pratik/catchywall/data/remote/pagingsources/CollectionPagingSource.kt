package com.pratik.catchywall.data.remote.pagingsources


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pratik.catchywall.data.model.CollectionResponseModelItem
import com.pratik.catchywall.data.remote.NetworkApi
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class CollectionPagingSource(
    private val networkApi: NetworkApi
) : PagingSource<Int, CollectionResponseModelItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CollectionResponseModelItem> {

        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = networkApi.getCollectionList(position, per_page = params.loadSize)

            LoadResult.Page(
                data = response,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (response.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CollectionResponseModelItem>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.

        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}