package com.pratik.catchywall.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratik.catchywall.data.model.PhotoDetailResponse
import com.pratik.catchywall.data.remote.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(private val photoRepository: PhotoRepository) : ViewModel() {

    val photoDetail = MutableLiveData<PhotoDetailResponse>()

    fun getPhotoDetail(id: String) = viewModelScope.launch {
        photoRepository.getPhotoDetail(id).collect {
            photoDetail.value =  it
        }
    }


}