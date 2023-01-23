package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentSearchPhotosBinding
import com.pratik.catchywall.presentation.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class SearchPhotosFragment : Fragment(R.layout.fragment_search_photos) {

    lateinit var fragmentSearchPhotosBinding: FragmentSearchPhotosBinding

    //    private val searchViewModel by viewModels<SearchViewModel>()
    private val searchViewModel by activityViewModels<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSearchPhotosBinding =
            FragmentSearchPhotosBinding.inflate(inflater, container, false)
        return fragmentSearchPhotosBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchViewModel.userSearchQuery.observe(viewLifecycleOwner) {
            it?.let { query ->
                lifecycleScope.launch {
                    searchViewModel.searchPhotoList(query).collectLatest { photoList ->

                    }
                }
            }
        }

    }
}