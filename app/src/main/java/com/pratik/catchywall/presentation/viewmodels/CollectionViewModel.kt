package com.pratik.catchywall.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pratik.catchywall.data.model.CollectionWallpaperListModelItem
import com.pratik.catchywall.data.remote.repository.CollectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(private val collectionRepository: CollectionRepository) :
    ViewModel() {

    val collectionList = collectionRepository.getCollectionList().cachedIn(viewModelScope)

    fun getCollectionWallpaperList(collectionId: String): Flow<PagingData<CollectionWallpaperListModelItem>> {
        return collectionRepository.getCollectionWallpaperList(collectionId)
            .cachedIn(viewModelScope)
    }

}