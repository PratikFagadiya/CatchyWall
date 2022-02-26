package com.pratik.catchywall.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pratik.catchywall.data.model.HomeResponseModelItem
import com.pratik.catchywall.data.remote.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(homeRepository: HomeRepository) : ViewModel() {

    val homePicList: Flow<PagingData<HomeResponseModelItem>>  = homeRepository.getHomePicsList().cachedIn(viewModelScope)

}