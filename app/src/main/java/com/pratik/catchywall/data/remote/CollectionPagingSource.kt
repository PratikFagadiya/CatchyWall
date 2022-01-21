package com.pratik.catchywall.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pratik.catchywall.data.model.CollectionResponseModel
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

private const val STARTING_PAGE_INDEX = 1

class CollectionPagingSource(
    private val networkApi: NetworkApi
) : PagingSource<Int, CollectionResponseModel>() {

    /**
     * The refresh key is used for subsequent calls to PagingSource.Load after the initial load.
     */
    override fun getRefreshKey(state: PagingState<Int, CollectionResponseModel>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CollectionResponseModel> {
        val position = params.key ?: STARTING_PAGE_INDEX


        return  try {
            val response = networkApi.getCollectionList(position)

            LoadResult.Page(
                data = listOf(response),
                prevKey = if (position == STARTING_PAGE_INDEX) null else -1,
                nextKey = if (position == STARTING_PAGE_INDEX) null else +1
            )
        }catch (exception: IOException){
            LoadResult.Error(exception)
        }catch (exception: HttpException){
            LoadResult.Error(exception)
        }
    }

}