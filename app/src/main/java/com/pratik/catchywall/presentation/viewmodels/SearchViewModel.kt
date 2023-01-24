package com.pratik.catchywall.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pratik.catchywall.data.model.HomeResponseModelItem
import com.pratik.catchywall.data.model.SearchCollectionResultResponseModel
import com.pratik.catchywall.data.model.User
import com.pratik.catchywall.data.remote.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
@Inject constructor(private val searchRepository: SearchRepository) : ViewModel() {

    var userSearchQuery: MutableLiveData<String> = MutableLiveData()

    fun searchPhotoList(query: String): Flow<PagingData<HomeResponseModelItem>> =
        searchRepository.getSearchPhotosList(query).cachedIn(viewModelScope)

    fun searchUserList(query: String): Flow<PagingData<User>> =
        searchRepository.getSearchUserList(query).cachedIn(viewModelScope)

    fun searchCollectionList(query: String): Flow<PagingData<SearchCollectionResultResponseModel>> =
        searchRepository.getSearchCollectionList(query).cachedIn(viewModelScope)

}