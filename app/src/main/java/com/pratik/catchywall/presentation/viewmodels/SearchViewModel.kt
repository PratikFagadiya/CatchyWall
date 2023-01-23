package com.pratik.catchywall.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pratik.catchywall.data.model.HomeResponseModelItem
import com.pratik.catchywall.data.remote.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
@Inject constructor(private val searchRepository: SearchRepository) : ViewModel() {

    fun searchPhotoList(query: String): Flow<PagingData<HomeResponseModelItem>> =
        searchRepository.getSearchPhotosList(query).cachedIn(viewModelScope)

}