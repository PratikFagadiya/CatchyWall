package com.pratik.catchywall.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.pratik.catchywall.data.remote.repository.CollectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(collectionRepository: CollectionRepository) : ViewModel() {

    val value = 1

}