package com.pratik.catchywall.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pratik.catchywall.data.remote.repository.CollectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(val collectionRepository: CollectionRepository) : ViewModel(){

//    fun getCollectionList(): Flow<PagingData<>>

    val collectionList =collectionRepository.getCollectionList().cachedIn(viewModelScope)



}