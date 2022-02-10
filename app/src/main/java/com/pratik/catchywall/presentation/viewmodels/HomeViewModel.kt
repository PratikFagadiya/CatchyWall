package com.pratik.catchywall.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.pratik.catchywall.data.remote.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(homeRepository: HomeRepository) : ViewModel() {

    val homePicList = homeRepository.getHomePicsList().cachedIn(viewModelScope)

}