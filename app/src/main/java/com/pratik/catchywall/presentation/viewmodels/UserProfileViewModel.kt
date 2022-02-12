package com.pratik.catchywall.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pratik.catchywall.data.model.UserProfilePhotosModelItem
import com.pratik.catchywall.data.remote.repository.UserProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(private val userProfileRepository: UserProfileRepository) :
    ViewModel() {

    fun getUserProfilePhotosList(userName: String): LiveData<PagingData<UserProfilePhotosModelItem>> {
        return userProfileRepository.getUserProfilePhotos(userName).cachedIn(viewModelScope)
    }


}